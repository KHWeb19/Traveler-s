<template>
<v-main>
		<v-app>
	<div align="center" class="home_wrap">
		<v-container>
			<v-row>
				<main-search :keyWord="keyWords"/>
			</v-row>
		</v-container>
		<v-container>
			<common-search :searchList="searchList"
							:keyWord="keyWords"/>
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
		},
   },
   data() {
	return {
		keyWords: null
	}
   },
   methods: {
    ...mapActions(["fetchSearchLists"]),
   },
    computed: {
    ...mapState(["searchList"])
  },
   mounted() {
	if(this.payload) {
		this.$store.state.searchKeyWord = this.payload
	}
	this.keyWords = this.$store.state.searchKeyWord
	this.fetchSearchLists(this.keyWords)

   }
}
</script>

<style scoped>
</style>