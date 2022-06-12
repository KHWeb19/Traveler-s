<template>
  <v-container>
    <h1 align="center">
      랜덤숙소 추천
    </h1>
    <div class="row">
      <div class="col-lg-4 col-xs-3">
        <v-card>
          <v-img src="@/assets/hotel.jpg"></v-img>
          <v-card-title class="justify-center">숙소이름</v-card-title>
          <v-card-text class="HotelName">
            <v-row align="center">
              <v-rating :value="5" color="amber" half-increments size="18" margin="0"></v-rating>

              <div class="grey--text ms-4">
                0~5점 (참여인수)
              </div>
            </v-row>
            <v-card-text>
              ₩ 100.000
            </v-card-text>
          </v-card-text>
          <v-divider></v-divider>
          <v-card-text>
            호텔위치 OO도OO시
          </v-card-text>
          <v-card-text>
            #무료주차 #오션뷰 #수영장
          </v-card-text>
        </v-card>
      </div>
    </div>
  </v-container>
</template>

<script>
export default {
  data: () => ({

  }),
  methods: {
    reserve() {
    },
  }
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
.v-img {
  height: 200px;
  width: 260px;
}
.HotelName {
  margin: 2px;
  padding: 0px;
}
.v-card-text {
  margin: 0px;
  padding: 0px;
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
.v-card-text{
  font-size: 15px;
}
</style>
