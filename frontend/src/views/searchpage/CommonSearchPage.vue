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
   created() {
	//그냥 state값 다 저장하면 this.$store.state로 가져와지는데
	//module 만들어서 가져오는건 getter쓴다는데 잘안되서
	//그냥 localStorage에 있는거 일단 가져오는 방식으로 함
	console.log(JSON.parse(localStorage.getItem('vuex')))
	const payload = JSON.parse(localStorage.getItem('vuex'))
	this.keyWords = payload.keyWord.searchKeyword
	console.log(this.keyWords)
	//검색
	this.fetchSearchLists(this.keyWords)
   }
}
</script>

<style scoped>
</style>