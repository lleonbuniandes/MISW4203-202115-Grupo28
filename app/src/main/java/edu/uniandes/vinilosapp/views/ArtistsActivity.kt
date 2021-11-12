package edu.uniandes.vinilosapp.views

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.toolbox.JsonArrayRequest
import edu.uniandes.vinilosapp.R
import kotlinx.android.synthetic.main.activity_artistas.*
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONException
import org.json.JSONObject


class ArtistsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_artistas)

        // make text view content scrollable
        textView.movementMethod = ScrollingMovementMethod()

        // url to get json array
        val url = "https://public-back-sandbox-vinyls.herokuapp.com/musicians"


        // get json array from url using volley network library

            progressBar.visibility = View.VISIBLE

            // request json array response from the provided url
            val request = JsonArrayRequest(
                Request.Method.GET, // method
                url, // url
                null, // json request
                {response -> // response listener
                    try {
                        textView.text = ""

                        // loop through the array elements
                        for (i in 0 until  response.length()){
                            // get current json object as student instance
                            val array: JSONObject = response.getJSONObject(i)

                            // get the current student (json object) data
                            val id: Int = array.getInt("id")
                            val name: String = array.getString("name")
                            val description: String = array.getString("description")
                            //val image: String = array.getString(image: "image")

                            // display the formatted json data in text view
                            textView.append("id: $id\n name: $name\n description: $description\n\n")
                        }

                    }catch (e: JSONException){
                        textView.text = e.message
                    }

                    progressBar.visibility = View.INVISIBLE
                },
                {error -> // error listener
                    textView.text = error.message
                    progressBar.visibility = View.INVISIBLE
                }
            )

            // add network request to volley queue
            VolleySingleton.getInstance(applicationContext)
                .addToRequestQueue(request)

    }
}
