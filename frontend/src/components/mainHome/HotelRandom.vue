<template>
  <v-container>
    <h1 align="center">
      랜덤숙소 추천
    </h1>
    <div class="row">
      <v-col v-for="Hotel in paginatedData"
              :key="Hotel.hotel_no"
            cols="12" sm="3" md="3" lg="3">
        <v-card 
          @click="clickHotel(Hotel.hotel_no, hotelName)">
          <img :src="Hotel.HotelImg.origFileName"/>
          <v-card-title class="justify-center">{{ Hotel.hotelname }}</v-card-title>
          <v-card-text>
            <v-row align="center">
              
            <!--별점 이쪽을 잘모르겠네요..-->
              <v-rating :value="5" color="amber" half-increments size="18" margin="0"></v-rating>   
              <div class="grey--text ms-4">
                0~5점 (참여인수)
              </div>


            </v-row>
            <v-card-text>

              {{ Hotel.room.price }}
            </v-card-text>
          </v-card-text>
          <v-divider></v-divider>
          <v-card-text>
            {{ Hotel.address }}
          </v-card-text>

<!-- 호탤 태그 가져와야 하는부분인데 이것도 맞는지 모르겠네요-->
          <v-card-text>
            {{ Hotel.hotel_info }}
          </v-card-text>

        </v-card>
      </v-col>
      </div>
    
  </v-container>
</template>

<script>
export default {
  name: 'HotelRandom',
  
  
}
</script>

<style scoped>
.v-container{
  width: 60%;
}
.v-card {
  height: 440px;
  width: 280px;
  padding: 10px;
}
.img {
  height: 200px;
  width: 260px;
}
.v-card-text {
  margin: 2px;
  padding: 0px;
  font-size: 15px;
}
.v-divider{
  color:rgb(150,150,150);
}
.v-rating{
  padding-left: 20px;
}
.v-rating .v-icon {
  padding-right: 1px;
    padding-left: 1px;
    padding: 0.1rem;
    border-radius: 50%;
}
</style>
