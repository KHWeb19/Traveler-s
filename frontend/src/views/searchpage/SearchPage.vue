<template>
	<div align="center" class="home_wrap">
		<v-container>
			<v-row>
				<MainSearch />
			</v-row>
		</v-container>
		<v-container>
			<detail-search :searchList="searchList"/>
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
   props: {
       searchList: {
           type:Array
       }
   },
   data () {
        return {
            word: ''
    }
   }
};

</script>



<style scoped>

</style>