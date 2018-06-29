package lmndevelopers.com.expensemanager.model

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import lmndevelopers.com.expensemanager.bean.DataStore
import lmndevelopers.com.expensemanager.presenter.PresenterApi
import lmndevelopers.com.expensemanager.view.MainActivity
import lmndevelopers.com.expensemanager.view.ViewApi

class model:PresenterApi {
    lateinit var dbase : SQLiteDatabase
    lateinit var mactivity : MainActivity
    constructor(v : ViewApi)
    {
        mactivity = v as MainActivity
        dbase = mactivity.openOrCreateDatabase("expense", Context.MODE_PRIVATE,null)
        dbase.execSQL("create table if not exists incexp(_id integer primary key autoincrement,type varchar(15),amount Integer,description varchar(200))")

    }



    override fun addIncome(datastore: DataStore) {
       var cv =ContentValues()
        cv.put("type",datastore.type)
        cv.put("amount",datastore.amount)
        cv.put("description",datastore.desc)

        if(datastore.type == "Income") {
            var status = dbase.insert("incexp", null, cv)
            when(status){
                -1.toLong() ->{mactivity.addIncomeResult("Record failed to insert") }
                else ->{mactivity.addIncomeResult("Record inserted sucessfully")}
            }
        }
        else {
            mactivity.addIncomeResult("Record failed to insert")
        }

    }

    override fun addExpense(datastore: DataStore) {
        var cv =ContentValues()
        cv.put("type",datastore.type)
        cv.put("amount",datastore.amount)
        cv.put("description",datastore.desc)

        if(datastore.type == "Expense") {
            var status = dbase.insert("incexp", null, cv)

            when (status) {
                -1.toLong() -> {
                    mactivity.addExpenseResult("Record failed to insert")
                }
                else -> {
                    mactivity.addExpenseResult("Record inserted sucessfully")
                }
            }
        }
        else{
            mactivity.addExpenseResult("Record failed to insert")
        }


    }

    override fun viewIncome() {
        var list = mutableListOf<DataStore>()
        var rows = dbase.query("incexp",null,"type=?", arrayOf("Income"),null,null,null)
        while(rows.moveToNext())
        {
            list.add(DataStore(rows.getInt(0),rows.getString(1),rows.getInt(2),rows.getString(3)))
        }

        mactivity.viewIncomeResult(list)
    }

    override fun viewExpense() {
        var list = mutableListOf<DataStore>()
        var rows = dbase.query("incexp",null,"type=?", arrayOf("Expense"),null,null,null)
        while(rows.moveToNext())
        {
            list.add(DataStore(rows.getInt(0),rows.getString(1),rows.getInt(2),rows.getString(3)))
        }

        mactivity.viewIncomeResult(list)


    }

    override fun viewIncExp() {
        var list = mutableListOf<DataStore>()
        var rows = dbase.query("incexp",null,null, null,null,null,null)
        while(rows.moveToNext())
        {
            list.add(DataStore(rows.getInt(0),rows.getString(1),rows.getInt(2),rows.getString(3)))
        }

        mactivity.viewIncExpResult(list)


    }


}