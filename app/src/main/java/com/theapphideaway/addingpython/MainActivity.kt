package com.theapphideaway.addingpython

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.chaquo.python.PyObject
import com.chaquo.python.Python
import com.chaquo.python.android.AndroidPlatform
import com.theapphideaway.addingpython.R.id.start
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (! Python.isStarted()) {
            Python.start(AndroidPlatform(this))
        }

        val py: Python = Python.getInstance()
        var pythonText = py.getModule("MyPythonClass").callAttr("get_python_text", "Ian")

        my_text_view.text = pythonText.toString()
    }

}
