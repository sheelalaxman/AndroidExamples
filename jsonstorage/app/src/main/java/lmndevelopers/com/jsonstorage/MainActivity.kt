package lmndevelopers.com.jsonstorage

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import java.io.FileInputStream
import java.io.InputStreamReader

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        insert.setOnClickListener {
            if (name.text.isEmpty() ||  desig.text.isEmpty() || dept.text.isEmpty())
            {
                Toast.makeText(this@MainActivity,"enter all the required fields",Toast.LENGTH_LONG).show()
            }
            else
            {
                var employee = Employee(name.text.toString() , desig.text.toString(),dept.text.toString())
                var foi : FileInputStream?
                var list: MutableList<Employee> = mutableListOf()
                try{
                    foi = openFileInput("empjson.json")
                }
                catch (e : Exception){

                    foi = null

                }
                if(foi == null)
                  list.add(employee)
                else
                {
                    var employees = Gson().fromJson(InputStreamReader(foi), Employees::class.java)
                    for (emp in employees.employee) {
                        list.add(emp)
                    }
                    list.add(employee)
                    foi!!.close()
                }
                var employees = Employees(list)
                var gson = Gson()
                var wrappedData = gson.toJson(employees)
                var fio = openFileOutput("empjson.json",Context.MODE_PRIVATE)
                fio.write(wrappedData.toByteArray())
                Toast.makeText(this@MainActivity,"Data inserted",Toast.LENGTH_LONG).show()
                fio.flush()
                fio.close()



            }
        }
        read.setOnClickListener {
             var fio : FileInputStream?
            try{
                fio = openFileInput("empjson.json")
            }
            catch (e : Exception){

                  fio = null

            }

              if(fio == null)
              {
                  Toast.makeText(this@MainActivity,"No records",Toast.LENGTH_LONG).show()
              }
             else {
                  var list: MutableList<String> = mutableListOf()
                  var employees = Gson().fromJson(InputStreamReader(fio), Employees::class.java)
                  for (emp in employees.employee) {
                      list.add("${emp.name}| ${emp.desig}|${emp.dept}")
                  }
                  var adapter = ArrayAdapter<String>(this@MainActivity, android.R.layout.simple_list_item_single_choice, list)
                  lview.deferNotifyDataSetChanged()
                  lview.adapter = adapter

                  fio.close()
              }
        }
    }
}
