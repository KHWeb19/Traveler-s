<template>
  <div>
    <bm-side-bar/>
      <h2>숙소 관리</h2>
      <span class="page-count">전체 0 {{ pageCount }} </span>
      <router-link :to="{ name: 'HotelRegisterPage' }" class="btn"><v-btn>숙소등록</v-btn></router-link>
      <br>
		<v-text-field v-model="searchkeyword" dense outlined class="searchkeyword"/>
    <v-icon>fas fa-search</v-icon>
    <i class="fas fa-search"></i>
    <!-- <v-btn @click="searchstart" :style="{marginTop:'10px'}">검색</v-btn>-->
    <hotel-list/>
  </div>
</template>

<script>

import HotelList from '@/components/hotel/HotelList.vue'
import BmSideBar from '@/components/layout/BmSideBar.vue';

export default {
    name: 'HotelListPage',
    components: {
        HotelList,
        BmSideBar
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
.v-btn:before {
  opacity: 0 !important;
}
.searchkeyword {
  width: 94.4%;
  padding: 20px 0px 30px 50px;
}
</style>