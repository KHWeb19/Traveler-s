<template>
  <v-container>
    <section>
      <v-card-title id="RandomTitle" class="justify-center" style="font-size:3em">랜덤숙소 추천</v-card-title>
      <div class="row">
        <v-col v-for="hotel in hotels" :key="hotel.hotelNo"
                cols="12" xs="12" sm="6" md="4" lg="3" xl="2">
          <v-card @click="readHotel(hotel.hotelNo)">
            <img id="HotelImg" style="height: 200px; width: 260px;"
              :src="require(`@/assets/hotelImg/${hotel.hotelImgPath1}`)" />
            <v-card-title id="hotelName" class="justify-center">{{ hotel.hotelName }}</v-card-title>
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
              {{ hotel.totalAddress }}
            </v-card-text>
            <span class="hotel_info">
              {{ "#" + hotel.hotelInfo[i] }}
            </span>
          </v-card>
        </v-col>
      </div>
    </section>
  </v-container>
</template>

<script>
export default {
  name: 'HotelRandom',
  props: {
    hotels: {
      type: Array
    }
  },
  methods: {
    readHotel(hotelNo) {
            this.$router.push({ name:'HotelReadPage', params: { hotelNo: hotelNo.toString() } })      
    }
  },
}

</script>

<style scoped>
.v-container{
  width: 60%;
  margin-top: 5%;
  margin-bottom: 10%;
}
.v-card {
  margin-top: 10%;
  margin-bottom: 10%;
  height: 600px;
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
}
.address{
  font-size: 1em;
}
#RandomTitle {
  min-width: 400px;
  margin-top: 2%;
  margin-bottom: 1%;
}
#HotelImg{
  margin-top:15px;
}
</style>