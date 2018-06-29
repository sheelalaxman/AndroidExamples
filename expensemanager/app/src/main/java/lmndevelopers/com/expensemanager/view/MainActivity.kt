package lmndevelopers.com.expensemanager.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import lmndevelopers.com.expensemanager.R
import lmndevelopers.com.expensemanager.bean.DataStore
import lmndevelopers.com.expensemanager.model.model

class MainActivity : ViewApi,AppCompatActivity() {

    private fun  showResult(list : MutableList<DataStore>)
    {
        var slist = mutableListOf<String>()
        for(bean in list)
        {
            slist.add("${bean._id}   ${bean.type} ${bean.amount} ${bean.desc}")
        }

        lview.adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_single_choice,slist)
    }

    override fun addIncomeResult(s: String) {

        Toast.makeText(this,s,Toast.LENGTH_LONG).show()

    }

    override fun addExpenseResult(s: String) {

        Toast.makeText(this,s,Toast.LENGTH_LONG).show()
    }

    override fun viewIncomeResult(list: MutableList<DataStore>)
    {
       showResult(list)
    }

    override fun viewExpenseResult(list: MutableList<DataStore>) {

        showResult(list)

    }

    override fun viewIncExpResult(list: MutableList<DataStore>) {

       showResult(list)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var handler = model(this)
        lateinit var data : DataStore

        addinc.setOnClickListener {
            data = DataStore(0,type.selectedItem.toString(),amount.text.toString().toInt(),desc.text.toString())
            handler.addIncome(data)

        }
        addexp.setOnClickListener {
            data = DataStore(0,type.selectedItem.toString(),amount.text.toString().toInt(),desc.text.toString())
            handler.addExpense(data)
        }
        viewinc.setOnClickListener {
            handler.viewIncome()
        }
        viewexp.setOnClickListener {
            handler.viewExpense()
        }
        viewincexp.setOnClickListener {
            handler.viewIncExp()
        }
    }


}
