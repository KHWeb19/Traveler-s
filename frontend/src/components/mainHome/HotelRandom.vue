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
            <span class="hotel_info" v-for="(info , i) in hotel.hotelInfo" :key="i">
              {{ "#" + info }}
            </span>
            <!--
            호탤 엔티티에있는 호텔인포 컬럼은 정보를 리스트형태로 저장하고있다.
            호텔인포 컬럼에 저장된 리스트를 포이치로 하나씩 떼어낸다.
            포이치로 뗴어낸 리스트를 infolist라고 부른다.
            for문을 사용하여 infolist의 모든 키워드가 남지않을때까지 반복시킨다.
            =infolist의 길이만큼 for문이 반복되도록 한다.
            for (infolistlength>=i; ;)
            -->
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
    },
    infos: {
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