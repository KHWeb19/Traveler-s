<template>
  <div align="center">
    <v-container>
      <form @submit="getRoomList()">
        <!-- 주석 -->

        <table style="width: 80%">
          <tr align="right">
            <td colspan="2"></td>
          </tr>

          <tr>
            <!-- 호텔 이미지 슬라이드 -->
            <td colspan="2">
              <div class="slide-9img">
                <v-container style="padding: 0px">
                  <v-carousel
                    v-if="Object.keys(mHotel).length !== 0"
                    cycle
                    hide-delimiters
                    class="cover"
                  >
                    <v-carousel-item
                      :src="
                        require(`@/assets/hotelImg/${mHotel.hotelImgPath1}`)
                      "
                    />
                    <v-carousel-item
                      :src="
                        require(`@/assets/hotelImg/${mHotel.hotelImgPath2}`)
                      "
                    />
                    <v-carousel-item
                      :src="
                        require(`@/assets/hotelImg/${mHotel.hotelImgPath3}`)
                      "
                    />
                    <v-carousel-item
                      :src="
                        require(`@/assets/hotelImg/${mHotel.hotelImgPath4}`)
                      "
                    />
                    <v-carousel-item
                      :src="
                        require(`@/assets/hotelImg/${mHotel.hotelImgPath5}`)
                      "
                    />
                    <v-carousel-item
                      v-if="mHotel.hotelImgPath6"
                      :src="
                        require(`@/assets/hotelImg/${mHotel.hotelImgPath6}`)
                      "
                    />
                    <v-carousel-item
                      v-if="mHotel.hotelImgPath7"
                      :src="
                        require(`@/assets/hotelImg/${mHotel.hotelImgPath7}`)
                      "
                    />
                    <v-carousel-item
                      v-if="mHotel.hotelImgPath8"
                      :src="
                        require(`@/assets/hotelImg/${mHotel.hotelImgPath8}`)
                      "
                    />
                    <v-carousel-item
                      v-if="mHotel.hotelImgPath9"
                      :src="
                        require(`@/assets/hotelImg/${mHotel.hotelImgPath9}`)
                      "
                    />
                  </v-carousel>
                </v-container>
              </div>
            </td>
            \
          </tr>

          <br />
          <tr>
            <!-- 숙소 이름, 한줄소개, 좋아요 -->
            <td>
              <h1>{{ mHotel.hotelName }}</h1>
              <p>{{ mHotel.hotelIntro }}</p>
            </td>
            <td>
              <v-col>
                <v-row>
                  <table style="margin-left: auto; margin-right: 10px">
                    <tr>
                      <v-img id="myImg" :src="require(`@/assets/hotel.jpg`)" />
                    </tr>
                  </table>
                  <table style="margin-right: 10px">
                    <tr>
                      <td>
                        <h3>{{ mHotel.writer }}</h3>
                      </td>
                    </tr>
                    <tr>
                      <td
                        text
                        onclick="window.open('https://open.kakao.com/o/sBJqEEme')"
                      >
                        <p>
                          <v-icon>mdi-chat-question-outline</v-icon> 카톡으로
                          문의하기
                        </p>
                      </td>
                    </tr>
                  </table>
                </v-row>
              </v-col>
            </td>
          </tr>

          <tr>
            <td colspan="2">
              <hr align="center" style="width: 100%" />
            </td>
          </tr>

          <tr>
            <!-- 이 숙소의 매력 포인트 태그 -->
            <td colspan="2">
              <br />
              <div align="center">
                <table style="width: 70%">
                  <tr>
                    <td>
                      <v-col>
                        <!-- hotelInfo라는 자료의 데이터 갯수만큼 반복이 된다. data 변수명은 item이라고 해준다.  -->
                        <!-- key의 용도는 반복문 돌린 요소를 컴퓨터가 구분하기 위한 것. 반복문 돌면서 변하는 숫자/문자   -->
                        <!-- 작명 두개 할 시(데이터 변수, 1씩 증가하는 정수 변수) / 이때 key에는 보통 정수 변수를 입력   -->
                        <v-row justify="center">
                          <span
                            id="tagSpan2"
                            v-for="(item, i) in mHotel.hotelInfo"
                            :key="i"
                            class="hotel_info"
                          >
                            {{ "#" + item }}
                            <!-- i 번째 item를 출력 -->
                          </span>
                        </v-row>
                      </v-col>
                    </td>
                  </tr>
                </table>
              </div>
              <br />
            </td>
          </tr>

          <tr>
            <td colspan="2">
              <hr align="center" style="width: 100%" />
            </td>
          </tr>
          <tr>
            <!-- 숙소 위치 + 카카오맵API -->
            <td colspan="2">
              <br />
              <h3>숙소 위치</h3>
              <p>{{ mHotel.totalAddress }}</p>
            </td>
          </tr>
          <td colspan="2" align="center">
            <kakao-map-api
              v-if="Object.keys(mHotel).length !== 0"
              :mHotel="mHotel"
            />
            <br />
          </td>
          <tr></tr>

          <tr>
            <td colspan="2">
              <hr align="center" style="width: 100%" />
            </td>
          </tr>
        </table>
        <br />
      </form>
    </v-container>
  </div>
</template>

<script>
import KakaoMapApi from "@/components/hotelDetail/KakaoMapApi.vue";
export default {
  name: "HotelReadForm",
  components: {
    KakaoMapApi,
  },
  data() {
    return {
      hotelInfo: [],
      pageArray: [],
    };
  },
  props: {
    mHotel: {
      type: Object,
      required: true,
    },
  },
  created() {
    this.hotelNo = this.mHotel.hotelNo;
  },
  methods: {},
};
</script>

<style scoped>
#inCard {
  border: 1px;
  color: black;
  vertical-align: middle;
}
#button {
  margin-top: 10px;
  margin-bottom: 10px;
  margin-left: 20px;
  padding-left: 30px;
  padding-right: 30px;
}
#tagSpan2 {
  margin: 10px;
  padding: 6px;
  padding-left: 20px;
  padding-right: 20px;
  border-radius: 5px;
  background-color: lightgray;
}
#myImg {
  width: 55px;
  height: 55px;
  border-radius: 25px;
}
/*table{
    border-collapse:collapse;
    border: 1px solid black;
} */
</style>
