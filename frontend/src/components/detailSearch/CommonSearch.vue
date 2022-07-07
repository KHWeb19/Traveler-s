<template>
  <v-container>
    <section>
      <div class="row">
        <v-col v-for="(mHotel , idx) in paginatedData" :key="idx" cols="12" xs="12" sm="6" md="4" lg="3" xl="2">
          <v-card @click="readHotel(mHotel)">
            <img id="HotelImg" style="height: 200px; width: 260px;"
              :src="require(`@/assets/hotelImg/${mHotel.hotelImages[0]}`)" />
            <v-card-title id="hotelName" class="justify-center">{{ mHotel.hotelName }}</v-card-title>
            <v-divider></v-divider>
            <v-card-text class="address">
              {{ mHotel.hotelAddress }}
            </v-card-text>
            <span class="hotel_info" v-for="(info , i) in mHotel.hotelInfo" :key="i">
              {{ "#" + info }}
            </span>
          </v-card>
        </v-col>
      </div>
    </section>

    <template>
        <v-container justify="center" >
         <v-row>
            <v-col>
            <div class="btn-cover" align="center">
                <v-btn
                    :disabled="pageNum === 0"
                    @click="prevPage"
                    class="page-btn">
                이전
                </v-btn>
                <span class="page-count"
                >{{ pageNum + 1 }} / {{ pageCount }} 페이지</span
                >
                <v-btn
                    :disabled="pageNum >= pageCount - 1"
                    @click="nextPage"
                    class="page-btn"
                >
                다음
                </v-btn>
            </div>
            </v-col>
         </v-row>
        </v-container>
    </template>


  </v-container>
</template>

<script>


export default {
  name: 'DetailSearch',
  props: {
    searchList: {
      type: Array
    },
    keyWord: {
      type: Object
    },
    pageSize: {
      type: Number,
      required: false,
      default: 4,
    }
  },
  data() {
        return {
            word: '',
            pageNum: 0,
        }
  },
  methods: {
    readHotel(mHotel) {
            const payload = this.keyWord
            console.log(payload)
            this.$router.push({ name:'MHotelReadPage', params: { hotelNo: mHotel.hotelNo.toString(), payload} })      
    },
    nextPage() {
        this.pageNum += 1;
    },
    prevPage() {
        this.pageNum -= 1;
    },
  },
  computed: {
      pageCount() {
          let listLeng = this.searchList.length,
              listSize = this.pageSize,
              page = Math.floor(listLeng / listSize);
          if (listLeng % listSize > 0) page += 1;
          return page;
      },
      paginatedData() {
          const start = this.pageNum * this.pageSize,
              end = start + this.pageSize;
          return this.searchList.slice(start, end);
      },
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