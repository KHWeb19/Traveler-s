<template>
  <v-container>
    <section>
      <v-row justify="center">
        <v-col justify="space-around" v-for="(mHotel , idx) in paginatedData" :key="idx" cols="12" xs="12" sm="6" md="4" lg="3" xl="2">
          <v-card @click="readHotel(mHotel)">
            <img id="HotelImg" style="height: 200px; width: 260px;"
              :src="require(`@/assets/hotelImg/${mHotel.hotelImages[0]}`)" />
            <v-card-title id="hotelName" class="justify-center">{{ mHotel.hotelName }}</v-card-title>
            <v-divider></v-divider>
            <v-card-text class="address">
              {{ mHotel.totalAddress }}
            </v-card-text>
            <v-card-text>
            <span class="hotel_info" v-for="(info , i) in mHotel.hotelInfo" :key="i">
              {{ "#" + info }}
            </span>
            </v-card-text>
          </v-card>
        </v-col>
      </v-row>
    </section>

    <template>
        <v-container justify="center" >
         <v-row>
            <v-col>
        <div class="btn-cover">
            <button :disabled="pageNum === 0" @click="prevPage" class="page-btn">
                <v-icon> mdi-chevron-left </v-icon>
            </button>
            &ensp;

                <span>{{ pageNum + 1 }} / {{ pageCount }} 페이지</span>

            &ensp;
            <button :disabled="pageNum >= pageCount - 1" @click="nextPage" class="page-btn">
                <v-icon> mdi-chevron-right </v-icon>  
            </button>
        </div>
            </v-col>
         </v-row>
        </v-container>
    </template>


  </v-container>
</template>

<script>
import { mapActions } from 'vuex'


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
      default: 6,
    }
  },
  data() {
        return {
            word: '',
            pageNum: 0,
        }
  },
  methods: {
     ...mapActions(["setHotelReadKeyWord"]),
    readHotel(mHotel) {
            const payload = {
              dates : this.keyWord.dates,
              personnel: this.keyWord.personnel,
              hotelNo: mHotel.hotelNo
            }
            //호텔 키워드 저장
            this.setHotelReadKeyWord(payload)
            console.log('coomon')
            console.log(payload)
            this.$router.push({ name:'MHotelReadPage', params: { hotelNo: mHotel.hotelNo.toString()} })      
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
  height: 450px;
  Min-width: 276px;
  max-width: 290px;
}
v-card-text {
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