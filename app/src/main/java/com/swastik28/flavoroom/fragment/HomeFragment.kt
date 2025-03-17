package com.swastik28.flavoroom.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.interfaces.ItemClickListener
import com.denzcoskun.imageslider.models.SlideModel
import com.swastik28.flavoroom.R
import com.swastik28.flavoroom.adapter.PopularAdapter
import com.swastik28.flavoroom.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater,container,false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val imageList = ArrayList<SlideModel>()
        imageList.add(SlideModel("https://img.freepik.com/free-psd/pizza-restaurant-ad-template-banner_23-2148789612.jpg?t=st=1741270749~exp=1741274349~hmac=9b2e40d6075be1c5ab8515ef73e913af32d80fea99fb23115002cab152f2fab2&w=1800", ScaleTypes.FIT))
        imageList.add(SlideModel("https://img.freepik.com/free-vector/flat-design-tasty-brunch-sale-background_23-2149202133.jpg?t=st=1741270321~exp=1741273921~hmac=4db2b8ff2e84b2a9e06f8ba94fb9ea3077df1898e033e3bb3fc60534260ddf18&w=1800", ScaleTypes.FIT))
        imageList.add(SlideModel("https://img.freepik.com/free-vector/flat-design-food-sale-background_23-2149173813.jpg?t=st=1741270801~exp=1741274401~hmac=1f70b8f01ca1c045ab8faec7200d4e89cb12e3ef31e8c909ca297dfb2b246302&w=1800", ScaleTypes.FIT))
        val imageSlider = binding.imageSlider
        imageSlider.setImageList(imageList)
        imageSlider.setImageList(imageList, ScaleTypes.FIT)
        imageSlider.setItemClickListener(object :ItemClickListener {
            override fun doubleClick(position: Int) {
                TODO("Not yet implemented")
            }

            override fun onItemSelected(position: Int) {

                val itemPosition = imageList[position]
                val itemMessage = "Selected Image $position"
                Toast.makeText(requireContext(),itemMessage, Toast.LENGTH_SHORT).show()
            }
        })
        val foodname = listOf("Burger","Sandwich","momo","item")
        val price = listOf("$5","$7","$8","$10")
        val popularFoodImages = listOf(R.drawable.menu_photo1,R.drawable.menu_photo2,R.drawable.menu_photo3,R.drawable.menu_photo)
        val adapter = PopularAdapter(foodname,price,popularFoodImages)
        binding.popularRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.popularRecyclerView.adapter = adapter
    }

    companion object {
    }

}