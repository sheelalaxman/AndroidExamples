package lmndevelopers.com.expensemanager.view

import lmndevelopers.com.expensemanager.bean.DataStore

interface ViewApi {
    fun addIncomeResult(s : String)
    fun addExpenseResult(s : String)
    fun viewIncomeResult(list: MutableList<DataStore>)
    fun viewExpenseResult(list: MutableList<DataStore>)
    fun viewIncExpResult(list: MutableList<DataStore>)
}