<template>
  <v-container>
    <section>
      <h3 class="titDep2">다양한 유형의 숙소를 확인해 보세요</h3>
      <v-row justify="center" >
        <v-col justify="space-around" v-for="mHotel in mHotels" :key="mHotel.hotelNo" cols="12" xs="12" sm="6" md="4" lg="3" xl="2">
          <v-card @click="readHotel(mHotel)">
            <img id="HotelImg" style="height: 200px; width: 260px;"
              :src="require(`@/assets/hotelImg/${mHotel.hotelImages[0]}`)" />
            <v-card-title id="hotelName" >{{ mHotel.hotelName }}</v-card-title>
            <!-- <v-card-text>
            별점 이쪽을 잘모르겠네요.. 시간되면 진행하는걸로! (좋아요 누적?)
            <v-row align="center">
              <v-rating :value="5" color="amber" half-increments size="18" margin="0"></v-rating>
              <div class="grey--text ms-4">
                0~5점 (참여인수)
              </div>
               </v-row>
            이것도 나중에? 진행할수있으면 진행!
            <v-card-text>
              {{ Hotel.room.price }}
            </v-card-text
          </v-card-text>-->
            <v-divider></v-divider>
            <v-card-text class="address">
              {{ mHotel.totalAddress }}
            </v-card-text>
            <v-card-text id="textSpan">
            <span id="tagSpan2"
            v-for="(item, i) in mHotel.hotelInfo"
            :key="i"
            class="hotel_info">
              {{ "#" + item }}
              <!-- i 번째 item를 출력  -->
            </span>
            </v-card-text>
          </v-card>
        </v-col>
      </v-row>
    </section>
  </v-container>
</template>

<script>
export default {
  name: 'HotelRandom',
  props: {
    mHotels: {
      type: Array
    }
  },
  methods: {
    readHotel(mHotel) {
      const personnel = '2'
      const dates = [new Date(Date.now() - new Date().getTimezoneOffset() * 60000).toISOString().substr(0,10), new Date(Date.now() - new Date().getTimezoneOffset() * 220000).toISOString().substr(0,10)]
      const hotelNo = mHotel.hotelNo
      const payload = { dates, personnel, hotelNo}
      console.log('random')
      console.log(payload)
      this.$router.push({
        name: 'MHotelReadPage',
        //인원수 디폴트 2명 , 날짜 오늘 - 오늘 날짜로 보내기 (어차피 앞에것만 씀)
        params: { hotelNo: mHotel.hotelNo.toString() , payload , mHotel }
      })
    }
  },
}

</script>

<style scoped>

    @font-face {
    font-family: 'NanumSquareRound';
    src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_two@1.0/NanumSquareRound.woff') format('woff');
}

h3 {
  font-family: 'NanumSquareRound';
  font-size: 1.6rem;
}

.v-container{
  width: 60%;
  margin-top: 5%;
  margin-bottom: 10%;
}
.v-card {
  margin-top: 10%;
  margin-bottom: 10%;
  height: 450px;
  Min-width: 276px;
  max-width: 290px;
}
.v-card-text {
  margin: 2px;
  padding: 0px;
  font-size: 15px;
}
.v-divider{
  color:rgb(150,150,150);
}

#hotelName{
    margin-top: 0px;
    margin-bottom: 3px;
    padding-top: 3px;
    padding-bottom: 3px;
    font-size: 1em;
    justify-content: center;
}
.address{
  font-size: 1em;
}
#RandomTitle {
  min-width: 400px;
  margin-top: 2%;
  margin-bottom: 1%;
  justify-content: center;
}
#HotelImg{
  margin-top:15px;
}
#textSpan {
  margin: 0 2px;
}
</style>