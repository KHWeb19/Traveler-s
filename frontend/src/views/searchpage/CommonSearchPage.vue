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
			<common-search :searchList="searchList"/>
		</v-container>
	</div>
	</v-app>
</v-main>
</template>

<script>
import MainSearch from '@/components/mainHome/MainSearch.vue'
import CommonSearch from '@/components/detailSearch/CommonSearch.vue'

export default {
	name: 'CommonSearchPage',
	components: {
		MainSearch,
		CommonSearch
		
	},
   props: {
		searchList: {
			type:Array
		}
   }
};
</script>

<style scoped>
</style>