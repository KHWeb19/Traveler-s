<template>
<div align="center">
  <img src="@/assets/hotelbackimg.jpg"/>
<v-container>
    <table style="width: 80%">
      <tr>
        <td align="left" colspan="2">
      <h2 class="pageTit">숙소 관리</h2>
        </td>
      </tr>
      <tr>
        <td align="left">
            <span class="page-count">전체</span>
        </td>
        <td align="right">
          <router-link :to="{ name: 'BHotelRegisterPage' }" class="btn"><v-btn>숙소등록</v-btn></router-link>
        </td>
      </tr>
      <tr>
        <td align="left" colspan="2">
          <hotel-list :bmHotels="bmHotels"
                          @deleteHotels="deleteHotels"/>
        </td>
      </tr>
    </table>
</v-container>
  </div>
</template>

<script>
import HotelList from '@/components/hotel/HotelList.vue'
import { mapState, mapActions } from 'vuex'
import axios from 'axios'

export default {
    name: 'HotelListPage',
    components: {
        HotelList,
    },
    computed: {
      ...mapState(['bmHotels'])
    },
    mounted () {
      this.fetchBmHotelList()
    },
    methods: {
      ...mapActions(['fetchBmHotelList']),

      deleteHotels(payload){
          
            const hotels = payload
      
            axios.post('http://localhost:7777/hotel/bm/deleteHotels', hotels)
                        .then(() => {
                            alert('삭제 되었습니다.')
                            this.$router.go()
                        })
                        .catch(() => {
                            alert('실패했습니다.')
                        })
        }
    }
}
</script>

<style scoped>

  div {
    -webkit-user-select:none;
    -moz-user-select:none;
    -ms-user-select:none;
    user-select:none;
    height: 100%;
  }
  .pageTit {
    padding: 50px 0px 30px 10px;
    font-family: 'NanumSquareRound';
    font-size: 2.0rem;
    line-height: 1.25;
    letter-spacing: -.01em;
    color: #202020;
    font-weight: 900;
  }
  .pageTit:after {
      content: '';
      display: inline-block;
      width: 4px;
      height: 4px;
      margin-bottom: 24px;
      border-radius: 50%;
      background-color: #e63668;
  }
  .page-count {
    margin-left: 15px;
    border: 1px;
    border-bottom: 5px solid #e63668;
    border-radius: 5px;
    padding: 5px 10px;
    outline: none;
    color: #18225c;
    -webkit-text-stroke: 0.7px #18225c;
  }
  .btn {
    margin-right: 15px;
    position: sticky;
    text-decoration: none;
  }

  img {
  width: 100%;
  height: 280px;
  object-fit: cover;
  /*
  background: linear-gradient(
            to bottom,
            rgba(255,255,255,0) 10%,
            rgba(255,255,255,0.5) 25%,
            rgba(255,255,255,0.7) 40%,
            rgba(255,255,255,1) 50%,
            rgba(255,255,255,1) 100%
          ), url(@/assets/hotelbackimg.jpg);
  background-repeat: no-repeat;*/
  
  }

</style>