<template>
  <div>
    <bm-side-bar/>
      <h2>숙소 관리</h2>
      <span class="page-count">전체</span>
      <router-link :to="{ name: 'HotelRegisterPage' }" class="btn"><v-btn>숙소등록</v-btn></router-link>
      <br>
    <hotel-list :hotels="hotels"/>
  </div>
</template>

<script>

import HotelList from '@/components/hotel/HotelList.vue'
import BmSideBar from '@/components/layout/BmSideBar.vue'
import { mapState, mapActions } from 'vuex'

export default {
    name: 'HotelListPage',
    components: {
        HotelList,
        BmSideBar
    },
    computed: {
      ...mapState(['hotels'])
    },
    mounted () {
      this.fetchHotelList()
    },
    methods: {
      ...mapActions(['fetchHotelList'])
    }
}
</script>

<style scoped>
div {
  -webkit-user-select:none;
  -moz-user-select:none;
  -ms-user-select:none;
  user-select:none
}
h2 {
  padding: 50px 0px 30px 50px;
}
.page-count {
  margin-left: 50px;
  border: none;
  border-bottom: 5px solid #1890ff;
  border-radius: 5px;
  padding: 5px 10px;
  outline: none;
  color: #1890ff;
}
.btn {
  position: sticky;
  left: 90%;
  text-decoration: none;
}
</style>