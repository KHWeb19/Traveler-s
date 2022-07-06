<template>
<v-main>
		<v-app>
	<div align="center" class="home_wrap">
		<v-container>
			<v-row>
				<main-search />
			</v-row>
		</v-container>
		<v-container>
			<common-search :searchList="searchList"
							:payload="payload"/>
		</v-container>
	</div>
	</v-app>
</v-main>
</template>

<script>
import MainSearch from '@/components/mainHome/MainSearch.vue'
import CommonSearch from '@/components/detailSearch/CommonSearch.vue'
import { mapActions, mapState } from 'vuex';


export default {
	name: 'CommonSearchPage',
	components: {
		MainSearch,
		CommonSearch
		
	},
   props: {
		payload: {
			type: Object
		}
   },
   methods: {
    ...mapActions(["fetchSearchLists"]),
   },
    computed: {
    ...mapState(["searchList"])
  },
   mounted() {
	this.fetchSearchLists(this.paylaod)

   }
};
</script>

<style scoped>
</style>