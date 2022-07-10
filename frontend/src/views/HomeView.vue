<template>
	<v-main>
		<v-app>

			<div align="center" class="home_wrap">
				<v-container>
					<v-row>
						<main-search/>
					</v-row>
				</v-container>
				
				<hotel-random :mHotels="mHotels"/><br><br><br><br>

				<v-container>
					<v-row>
						<tag-search/>
					</v-row>
				</v-container>

				<v-container>
						<!-- 서비스 이용 안내 -->
						<service-info-use/>

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
import ServiceInfoUse from '@/components/mainHome/ServiceInfoUse.vue'
import MainFooterTop from '@/components/mainHome/MainFooterTop.vue';

import { mapState, mapActions } from 'vuex'

export default {
	components: {
		MainSearch,
		HotelRandom,
		TagSearch,
		ServiceInfoUse,
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
	...mapActions(['fetchMHotelList']),
   },
   created(){
		this.$store.state.num = 0
   }
};

</script>

<style scoped>

</style>