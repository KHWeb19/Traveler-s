<template>
  <v-container>
    <section>
      <div class="row">
        <v-col v-for="hotel in searchList" :key="hotel.hotelNo" cols="12" xs="12" sm="6" md="4" lg="3" xl="2">
          <v-card @click="readHotel(hotel.hotelNo)">
            <img id="HotelImg" style="height: 200px; width: 260px;"
              :src="require(`@/assets/hotelImg/${hotel.hotelImgPath1}`)" />
            <v-card-title id="hotelName" class="justify-center">{{ hotel.hotelName }}</v-card-title>
            <v-divider></v-divider>
            <v-card-text class="address">
              {{ hotel.hotelAddress }}
            </v-card-text>
            <span class="hotel_info" v-for="(info , i) in hotel.hotelInfo" :key="i">
              {{ "#" + info }}
            </span>
          </v-card>
        </v-col>
      </div>
    </section>
  </v-container>
</template>

<script>

export default {
  name: 'DetailSearch',
  props: {
    hotels: {
      type: Array
    }
  },
  data() {
    return {
      searchList: []
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
#spaninfo{
  margin: 1%;
}
</style>