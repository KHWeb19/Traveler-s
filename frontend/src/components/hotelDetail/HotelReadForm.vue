<template>
  <div align="center">
    <v-container>
      <form @submit="getRoomList()">
        <!-- 주석 -->

        <table style="width: 100%">
          <tr align="right">
            <!-- 좋아요 -->
            <td colspan="2">
              <v-btn id="heart" style="box-shadow:none; background:none;">
                <!--이 태그 안에 @click=""해서 작업하시면 됩니다. -->
                <v-icon v-if="checkWish == false" @click="wish"> mdi-cards-heart </v-icon>
                <v-icon v-if="checkWish == true" @click="wish" color="#e63668"> mdi-cards-heart </v-icon>
              </v-btn>
            </td>
          </tr>

          <tr>
            <!-- 호텔 이미지 슬라이드 -->
            <td colspan="2">
              <v-col align="center" class="slide-9img">
                <v-col class="picture" style="padding: 0px">
                  <v-carousel v-if="Object.keys(mHotel).length !== 0" cycle hide-delimiters class="cover">
                    <v-carousel-item class="hotelImg" v-for="(item, index) in mHotel.hotelImages" :key="index"
                      :src="require(`@/assets/hotelImg/${item}`)">
                    </v-carousel-item>
                  </v-carousel>
                </v-col>
              </v-col>
            </td>
          </tr>

          <br />
          <tr>
            <!-- 숙소 이름, 한줄소개, 좋아요 -->
            <td>
              <h1 id="hotelName">{{ mHotel.hotelName }}</h1>
              <p id="hotelInfo">{{ mHotel.hotelIntro }}</p>
            </td>
            <td>
              <v-col id="nameRight">
                <v-row>
                  <table>
                    <tr>
                      <v-img id="myImg" :src="require(`@/assets/hotel.jpg`)" />
                    </tr>
                  </table>
                  <table>
                    <tr>
                      <td>
                        <h3>{{ mHotel.writer }}</h3>
                      </td>
                    </tr>
                    <tr>
                      <td text onclick="window.open('https://open.kakao.com/o/sBJqEEme')">
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
                <table style="width: 80%">
                  <tr>
                    <td>
                      <v-col>
                        <!-- hotelInfo라는 자료의 데이터 갯수만큼 반복이 된다. data 변수명은 item이라고 해준다.  -->
                        <!-- key의 용도는 반복문 돌린 요소를 컴퓨터가 구분하기 위한 것. 반복문 돌면서 변하는 숫자/문자   -->
                        <!-- 작명 두개 할 시(데이터 변수, 1씩 증가하는 정수 변수) / 이때 key에는 보통 정수 변수를 입력   -->
                        <v-row>
                          <span id="tagSpan2" v-for="(item, i) in mHotel.hotelInfo" :key="i" class="hotel_info">
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
              <h3 id="addressTitle">숙소 위치</h3>
              <p id="hotelAddress">{{ mHotel.totalAddress }}</p>
            </td>
          </tr>



          <tr>
            <td colspan="2" align="center">
              <kakao-map-api id="hotelMap" v-if="Object.keys(mHotel).length !== 0" :mHotel="mHotel" />
              <br />
            </td>
          </tr>

          <tr>
            <td colspan="2">
              <hr align="center" style="width: 100%" />
            </td>
          </tr>
        </table>
      </form>
    </v-container>

    <m-room-read-form :payload="payload" :mRooms="mRooms" :hotelNo="hotelNo" />
  </div>
</template>

<script>
import KakaoMapApi from "@/components/hotelDetail/KakaoMapApi.vue";
import MRoomReadForm from "@/components/hotelDetail/RoomReadForm.vue";
import axios from "axios";
import { mapActions, mapState } from 'vuex';
export default {
  name: "HotelReadForm",
  components: {
    KakaoMapApi,
    MRoomReadForm,
  },
  data() {
    return {
      hotelInfo: [],
      pageArray: [],
      checkWish: false
    };
  },
  props: {
    mHotel: {
      type: Object,
      required: true,
    },
    payload: {
      type: Object
    },
    hotelNo: {
      type: String
    }
  },
  computed: {
    ...mapState(['mRooms'])
  },
  methods: {
    ...mapActions(['fetchMRoomList']),
    wish() {
      console.log(this.mHotel.hotelNo);
      if (this.checkWish == false) {
        axios.get(`http://localhost:7777/wish/${this.mHotel.hotelNo}`, {})
          .then((res) => {
            this.checkWish = res.data
            console.log(this.checkWish)
            alert("저장 성공");
          })
          .catch(() => {
            alert("등록 실패");
          });
      } else {
        axios.delete(`http://localhost:7777/wish/${this.mHotel.hotelNo}`)
          .then((res) => {
            this.checkWish = res.data
            console.log(this.checkWish)
            alert("삭제 되었습니다");
          })
          .catch(() => {
            alert("등록 실패");
          });
      }
    },
  },
  mounted() {
    this.fetchMRoomList(this.payload)
  }
};
</script>

<style scoped>
h1 {
  font-family: 'NanumSquareRound';
  color: #202020;
}

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
  background-color: #f8f8f8;
  margin: 10px;
  padding: 6px;
  padding-left: 20px;
  padding-right: 20px;
  background-color: #f8f8f8;
  display: inline-block;
  position: relative;
  border-radius: 20px;
  text-decoration: none;
  margin: 0.7em;
  font-size: 1.0em;
  font-weight: 500;
  font-family: Pretendard, -apple-system, BlinkMacSystemFont, Open Sans, Helvetica Neue, sans-serif;
  ;
  color: #404040;
}

#myImg {
  width: 55px;
  height: 55px;
  border-radius: 25px;
}

.picture {
  margin: 0%;
}

.cover {
  width: 60%;
  height: 800px;
  margin: 0% 2%;
}

.hotelImg {
  width: 100%;
}

#heart {
  margin: 0 20% 0% 0;
}

#nameRight {
  margin: 0 1% 1% 65%;
}

#hotelMap {
  min-width: 500px;
}

#hotelAddress {
  padding: 0 0 5px 15px;
}

#addressTitle {
  padding: 0 0 5px 15px;
}

#hotelName {
  margin: 0 1% 1% 5%;
}

#hotelInfo {
  margin: 0 1% 4% 5%;
}

@media screen and (min-width: 960px) and (max-width: 1264px) {
  #nameRight {
    margin: 0 1% 1% 62%;
  }
}

@media screen and (min-width: 800px) and (max-width: 960px) {
  #nameRight {
    margin: 0 1% 1% 55%;
  }
}

@media screen and (min-width: 680px) and (max-width: 800px) {
  #nameRight {
    margin: 0 1% 1% 45%;
  }
}

@media screen and (max-width: 680px) {
  #nameRight {
    margin: 0 1% 1% 10%;
  }
}

/*table{
    border-collapse:collapse;
    border: 1px solid black;
} */
</style>
