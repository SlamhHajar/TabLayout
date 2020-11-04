package com.hajarslamah.tablayout

import android.graphics.Color.red
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "position"

/**
 * A simple [Fragment] subclass.
 * Use the [FristFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FristFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var position: Int? = null
lateinit var frgTextView:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            position = it.getInt(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //To One Fragment
         var vew =inflater.inflate(R.layout.fragment_frist, container, false)
        frgTextView=vew.findViewById(R.id.OneFragment) as TextView
///////////////////////to control of viewpager2 the color and text
        if (position==0){
            vew.setBackgroundResource(R.color.design_default_color_secondary)
            frgTextView.setText("#This is fragment$position")
        }

       else if(position==1)
        {
            vew.setBackgroundResource(R.color.colorPrimaryDark)
            frgTextView.setText("#This is fragment $position")
        }

      else  if(position==2)
        {
            vew.setBackgroundResource(R.color.design_default_color_error )
            frgTextView.setText("#This is fragment $position")
        }

        return vew

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FristFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, position: Int) =
            FristFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putInt(ARG_PARAM2,position)
                }
            }
    }
}