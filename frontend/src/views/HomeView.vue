<template>
	<div align="center" class="home_wrap">
		<v-container>
			<v-row>
				<MainSearch/>
			</v-row>
			<v-row>
			<hotel-random :hotels="hotels" :list-array="pageArray"/>
			</v-row>
		</v-container>
		<v-container>
			<v-row>
				<TagSearch/>
			</v-row>
		</v-container>
	</div>
</template>


<script>
import MainSearch from '@/components/mainHome/MainSearch.vue'
import HotelRandom from '@/components/mainHome/HotelRandom.vue';
import TagSearch from '@/components/mainHome/TagSearch.vue';

import { mapState, mapActions } from 'vuex'
import axios from 'axios';

export default {
	components: {
		MainSearch,
		HotelRandom,
		TagSearch
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
        .get("http://localhost:7777/hotel/list")
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