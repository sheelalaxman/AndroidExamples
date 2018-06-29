package lmndevelopers.com.expensemanager.presenter

import lmndevelopers.com.expensemanager.bean.DataStore

interface PresenterApi {

    fun addIncome(datastore : DataStore)
    fun addExpense(datastore : DataStore)
    fun viewIncome()
    fun viewExpense()
    fun viewIncExp()
}