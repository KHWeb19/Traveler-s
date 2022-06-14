<template>
	<div class="home_wrap">
		<v-container>
			<v-row>
				<ChoseDate></ChoseDate>
				<ChoseNum></ChoseNum>
			</v-row>
		</v-container>
		<HotelRandom></HotelRandom>
		<section id="theme_search">
			<div class="inner">
<<<<<<< HEAD
				<v-spacer></v-spacer>
=======
				<v-btn @click="listall">listall</v-btn>
				<h1>테마검색</h1>

>>>>>>> upstream/main
				<div class="theme">
					<v-container style="width: 1200px">
						<v-row justify="center">
							<v-card align="center">

							</v-card>
						</v-row>
					</v-container>
				</div>
			</div>
		</section>
	</div>
</template>


<script>
<<<<<<< HEAD
import ChoseNum from '@/components/mainHome/ChoseNum.vue'
import ChoseDate from '@/components/mainHome/ChoseDate.vue';
import HotelRandom from '@/components/mainHome/HotelRandom.vue';

  export default {
 components: {
	ChoseNum,
	ChoseDate,
	HotelRandom
   },

   data: ()=>({

   }),
  };
=======
import axios from 'axios'
>>>>>>> upstream/main

export default {
		methods: {
			listall(){
				axios.get("http://localhost:7777/listall")
					.then(res => console.log(res.data))
					.catch(err => alert(err))
			}
		}
	}
</script>



<style scoped>

	.home_wrap {
		/*width: 1200px;*/
		width: 100%;
		font-family: 'Gowun Dodum', sans-serif;
	}

	h1 {
		font-size: 33px;
		font-weight: bold;
		color: #000;
	}

	strong, em {
		font-style: normal;
		font-weight: normal;
	}

	ol, ul {
		padding-left: 0;
	}

	.v-application a {
		color: #000;
	}

	/* 테마검색 */
	#theme_search {
		width: 100%;
		padding: 50px 0px;
		box-sizing: border-box;
		transition: 0.5s;
		background-color: rgb(255, 255, 255);
		margin-top: 50px;
	}

	#theme_search:after {
		content: "";
		display: block;
		clear: both;
	}

	#theme_search .inner {
		width: 1180px;
		margin: 0 auto;
	}

	#theme_search .inner h1 {
		float: center;
		margin-bottom: 35px;
		font-size: 25px;
	}
	#theme_search .inner .theme {
		transition: 0.5s;
		box-sizing: border-box;
	}

	#theme_search .inner .theme article {
		float: left;
		margin-left: 165px;
		width: 58px;
	}

	#theme_search .inner .theme article:nth-of-type(1) {
		margin-left: 0px;
	}

	#theme_search .inner .theme article .pic {
		width: 100%;
		height: 58px;
		text-align: center;
	}

	#theme_search .inner .theme article .pic > i {
		font-size: 40px;
		color: #777;
		transition: .3s;
	}

	#theme_search .inner .theme article .pic > p {
		font-size: 11px;
		margin-top: 10px;
	}

	#theme_search .inner .theme article .pic:hover i {
		transform: scale(1.2);
	}

</style>
