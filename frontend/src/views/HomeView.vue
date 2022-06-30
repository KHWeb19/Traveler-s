<template>
	<v-main>
		<v-app>
			<div align="center" class="home_wrap">
				<v-container>
					<v-row>
						<main-search/>
					</v-row>
				</v-container>
				<hotel-random :mHotels="mHotels" :list-array="pageArray"/>
				<v-container>
					<v-row>
						<tag-search :mHotels="mHotels"/>
					</v-row>
				</v-container>
			</div>
			<footer>
				<main-footer-top/>
			</footer>
		</v-app>
	</v-main>
</template>

<script>
import MainSearch from '@/components/mainHome/MainSearch.vue'
import HotelRandom from '@/components/mainHome/HotelRandom.vue';
import TagSearch from '@/components/mainHome/TagSearch.vue';
import MainFooterTop from '@/components/mainHome/MainFooterTop.vue';

import { mapState, mapActions } from 'vuex'
import axios from 'axios';

export default {
	components: {
		MainSearch,
		HotelRandom,
		TagSearch,
		MainFooterTop
	},
   data () {
	return {
		pageArray: [],
	}
   },
   computed: {
	...mapState(['mHotels'])
   },
   mounted () {
	this.fetchMHotelList()
   },
   methods: {
	...mapActions(['fetchMHotelList', 'fetchMHotel']),
   },
   created(){
      axios
        .get("http://localhost:7777/hotel/mainList")
        .then((res) => {
			console.log(res.data)
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