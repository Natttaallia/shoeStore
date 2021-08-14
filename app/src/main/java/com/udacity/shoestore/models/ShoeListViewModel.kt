package com.udacity.shoestore.models

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import timber.log.Timber

/**
 * @author Kulbaka Nataly
 * @date 22.07.2021
 */
class ShoeListViewModel : ViewModel() {

    private val _shoesList = MutableLiveData<MutableList<Shoe>>()
    val shoesList: MutableLiveData<MutableList<Shoe>>
        get() = _shoesList

    init {
        _shoesList.value = mutableListOf()
        createShoe(
            "HOKA ONE ONE Women's Mach 4 - White", 8.0, "Fiesta",
            "The HOKA ONE ONE Mach 4 gives your a responsive, energetic ride that is designed for logging long miles! The HOKA ONE ONE Mach 4 delivers a daily dose of speed that is unquestionably HOKA.\n" +
                    "\n" +
                    "Engineered Mesh delivers breathable comfort \n" +
                    "Anatomical Achilles construction \n" +
                    "PROFLY midsole to provide a cushioned landing and propulsive toe-of \n" +
                    "Early stage Meta-Rocker \n" +
                    "Rubberized EVA outsole provides lightweight ground contact\n" +
                    "TPU embroidered yarn\n" +
                    "Heel to toe Drop : 5mm\n" +
                    "Weight: 7.1oz\n" +
                    "Style #: 1113529-WFS"
        )
        createShoe(
            "Women's Parker - Sage", 6.0, "SHUSHOP",
            "The perfect mix of sporty meets trendy! Shapes these shoes with a rounded toe and a lace-up vamp. \n" +
                    "\n" +
                    "Cushioned insole\n" +
                    "Rubber sole has nonskid markings\n" +
                    "Man made materials\n" +
                    "Style #: Parker/Sage"
        )
        createShoe(
            "Men's Targhee III Oxford - Dark Earth / Mulch", 8.0, "KEEN",
            "The popular KEEN Targhee III boot s now in shoe form designed for everyday wear! This shoe offers the same benefits as the Targhee III when it comes to traction, fit, and comfort!\n" +
                    "\n" +
                    "Non-marking rubber outsole leaving no trace\n" +
                    "Premium leather upper\n" +
                    "KEEN.ALL-TERRAIN\n" +
                    "Removal Dual-Density EVA  Midsole\n" +
                    "Breathable mesh lining and lightweight cushioning\n" +
                    "4 mm mulit-directional lugs\n" +
                    "Style # : 1022513"
        )
        createShoe(
            "Men's Fresh Foam X Vongo v5 - Oxygen Blue with Laser Blue", 9.0, "New Balance",
            "Experience Fresh Foam X, medial post for pronation control and hypoknit uppers in the supportive and cushioned Fresh Foam X Vongo v5.\n" +
                    "\n" +
                    "Fresh Foam midsole cushioning is precision engineered to deliver an ultra-cushioned, lightweight ride\n" +
                    "Hypoknit upper with embroidery for zonal support\n" +
                    "Medial post helps control pronation\n" +
                    "Lace-up closure for a secure fit\n" +
                    "8 mm drop; due to variances created during the development and manufacturing processes, all references to 8 mm drop are approximate\n" +
                    "Weight: 9.9 OZ | 280 G\n" +
                    "Style # MVNGOBP5"
        )
        createShoe(
            "Birkenstock Franca Oiled Leather - Black (Regular Width)", 7.0, "Birkenstock",
            "Step up your warm weather sandal style and comfort with the Birkenstock Franca sandals!\n" +
                    "\n" +
                    "Anatomically shaped cork-latex footbed\n" +
                    "Upper: Oiled Leather\n" +
                    "Footbed lining: suede\n" +
                    "Sole: EVA\n" +
                    "Details: three straps, each with an individually adjustable metal pin buckle\n" +
                    "Made in Germany\n" +
                    "Style # 1021112"
        )
    }

    private fun createShoe(name: String, size: Double, company: String, description: String) {
        _shoesList.value?.add(Shoe(name, size, company, description))
    }

    fun onSave(name: String, size: String, company: String, description: String) {
        var sizeDouble = 0.0
        try {
            sizeDouble = when {
                size.isEmpty() -> 0.0
                size == "." -> 0.0
                size == "-" -> -.0
                else -> size.toDouble()
            }
        } catch (e: NumberFormatException) {
            Timber.i(e)
        }
        createShoe(name, sizeDouble, company, description)
    }
}