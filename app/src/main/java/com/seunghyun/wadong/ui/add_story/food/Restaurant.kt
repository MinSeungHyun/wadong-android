package com.seunghyun.wadong.ui.add_story.food

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.Serializable

data class Restaurant(val name: String, val address: String, val category: String, val image: String) : Serializable

fun getRestaurants(): List<Restaurant> {
    val type = object : TypeToken<List<Restaurant>>() {}.type
    return Gson().fromJson<List<Restaurant>>(JSON, type)
}


private var JSON = """
    [
      {
        "name": "계절밥상 용산아이파크몰점",
        "address": "서울특별시 용산구 한강로3가 40-999",
        "category": "한정식",
        "image": "https://img.siksinhot.com/place/1417245142117606.png"
      },
      {
        "name": "갈비씨 신용산점",
        "address": "서울특별시 용산구 한강로2가 2-194",
        "category": "그밖에또다른것",
        "image": "https://img.siksinhot.com/place/1519101510428661.jpg"
      },
      {
        "name": "플로이 용산점",
        "address": "서울특별시 용산구 한강로2가 424",
        "category": "브런치",
        "image": "https://img.siksinhot.com/place/1533528305128669.jpg"
      },
      {
        "name": "샤이바나 용산아이파크몰점",
        "address": "서울특별시 용산구 한강로3가 40-999 아이파크몰 서관 7층 샤이바나",
        "category": "그밖에또다른것",
        "image": "https://img.siksinhot.com/place/1519086996856549.jpg"
      },
      {
        "name": "현선이네 (용산본점)",
        "address": "서울특별시 용산구 한강로2가 305-1",
        "category": "떡볶이/순대/튀김/만두",
        "image": "https://img.siksinhot.com/place/1485395338888201.jpg"
      },
      {
        "name": "놀부보쌈&부대찌개 용산역사아이파크몰점",
        "address": "서울특별시 용산구 한강로3가 40-999 현대아이파크몰",
        "category": "찌개/전골/국/탕",
        "image": "https://img.siksinhot.com/place/1455055775940794.jpg"
      },
      {
        "name": "홍콩반점0410 용산문배점",
        "address": "서울시 용산구 문배동 24-8 용산프라임팰리스 2층",
        "category": "중국음식",
        "image": "https://img.siksinhot.com/place/1443443719952507.jpg"
      },
      {
        "name": "이북집 찹쌀순대 용산점",
        "address": "서울시 용산구 한강로2가 127-1",
        "category": "순대국",
        "image": "https://img.siksinhot.com/place/1374202848123214.png"
      },
      {
        "name": "영덕식당 용산점",
        "address": "서울 용산구 용산동3가 1-68",
        "category": "회",
        "image": "https://img.siksinhot.com/place/1385362968329734.jpg"
      },
      {
        "name": "캘리포니아피자키친 용산아이파크몰점",
        "address": "서울특별시 용산구 한강로3가 40-999",
        "category": "피자",
        "image": "https://img.siksinhot.com/place/1497578064351531.jpg"
      },
      {
        "name": "이자와 용산아이파크몰점",
        "address": "서울특별시 용산구 한강로3가 40-999 I PARK MALL 서관 7층 002-006호",
        "category": "일본음식/초밥",
        "image": "https://img.siksinhot.com/place/1513663753607095.jpg"
      },
      {
        "name": "경성함바그 용산아이파크몰점",
        "address": "서울특별시 용산구 한강로3가 40-999",
        "category": "스테이크하우스",
        "image": "https://img.siksinhot.com/place/1518929042250187.jpg"
      },
      {
        "name": "원효림",
        "address": "서울특별시 용산구 원효로2가 1-70",
        "category": "소주",
        "image": "https://img.siksinhot.com/place/1548826199153035.jpg"
      },
      {
        "name": "본초불닭발 원효점",
        "address": "서울특별시 용산구 용문동 23-4",
        "category": "닭볶음탕/닭갈비/닭발",
        "image": "https://img.siksinhot.com/place/1519005922982275.jpg"
      },
      {
        "name": "구룡포막회 원효로점",
        "address": "서울특별시 용산구 용문동 28-20",
        "category": "회",
        "image": "https://img.siksinhot.com/place/1519006893212291.jpg"
      },
      {
        "name": "복래춘",
        "address": "인천광역시 중구 선린동 10-2",
        "category": "중국음식",
        "image": "https://img.siksinhot.com/place/1464571735764536.png"
      },
      {
        "name": "대창반점",
        "address": "인천시 중구 선린동 29-4",
        "category": "중국음식",
        "image": "https://img.siksinhot.com/place/1358619339107885.jpg"
      },
      {
        "name": "중국성",
        "address": "인천시 중구 선린동 30",
        "category": "중국음식",
        "image": "https://img.siksinhot.com/place/1358620261349990.jpg"
      },
      {
        "name": "풍미",
        "address": "인천시 중구 선린동 32",
        "category": "중국음식",
        "image": "https://img.siksinhot.com/place/1358619046554843.jpg"
      },
      {
        "name": "본토만다복",
        "address": "인천시 중구 선린동 5",
        "category": "중국음식",
        "image": "https://img.siksinhot.com/place/1358617127949395.jpg"
      },
      {
        "name": "태화원",
        "address": "인천광역시 중구 선린동 22",
        "category": "중국음식",
        "image": "https://img.siksinhot.com/place/1358617249704426.jpg"
      },
      {
        "name": "태림봉",
        "address": "인천시 중구 선린동 6",
        "category": "중국음식",
        "image": "https://img.siksinhot.com/place/1358618769148794.jpg"
      }
    ]
""".trimIndent()