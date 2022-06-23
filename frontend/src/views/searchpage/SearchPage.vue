<template>
	<div align="center" class="home_wrap">
		<v-container>
			<v-row>
				<MainSearch />
			</v-row>
		</v-container>
		<v-container>
			<DetailSearch :hotels="hotels" :list-array="pageArray"/>
		</v-container>
	</div>
</template>

<script>

import MainSearch from '@/components/mainHome/MainSearch.vue';
import DetailSearch from '@/components/detailSearch/DetailSearch.vue';

import { mapState, mapActions } from 'vuex'
import axios from 'axios';

export default {
	components: {
		MainSearch,
		DetailSearch
		
	},
   data () {
	return {
		pageArray: [],
	}
   },
   computed: {
	...mapState(['hotels'])
   },
   mounted () {
	this.fetchHotelList()
   },
   methods: {
	...mapActions(['fetchHotelList', 'fetchHotel']),
   },
   created(){
      axios
        .get("http://localhost:7777/hotel/mainList")
        .then((res) => {
        this.pageArray = res.data;
        })
        .catch((err) => {
        console.log(err);
		});
   }
};

</script>



<style scoped>

</style>