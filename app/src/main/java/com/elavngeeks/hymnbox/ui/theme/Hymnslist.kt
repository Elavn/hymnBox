package com.elavngeeks.hymnbox.ui.theme

import androidx.annotation.DrawableRes

data class Hymnslist(
    val id: String,
    val hymnName: String
)

class HymnDataSource{
    fun loadHymns(): List<Hymnslist>{
        return listOf(
            Hymnslist("01", "Abasi nnyin ofon eti"),
            Hymnslist("02", "Edi yak nnyin ikwo"),
            Hymnslist("03", "Edi owo akpaimo,...."),
            Hymnslist("04", "Ukpono enyene Ete,..."),
            Hymnslist("05", "Abasi nnyin, itoro Fi"),
            Hymnslist("06", "Efiori ke ndaresit"),
            Hymnslist("07", "Abasi mi, nkpono Fi"),
            Hymnslist("08", "Se Obon etie k'ubon"),
            Hymnslist("09", "Angel esikwo k'enyon ko"),
            Hymnslist("10", "Nyekwo ima Jehovah mi"),
            Hymnslist("11", "Edisana Abasi, Akwa Obon nnyin"),
            Hymnslist("12", "Toro Edidem, Obon nnyin k'enyon"),
            Hymnslist("13", "Ukpon mi toro Jehovah"),
            Hymnslist("14", "K'ini ukpon mi etide"),
            Hymnslist("15", "Ekwo eno Obon k'ima"),

        )
    }
}
