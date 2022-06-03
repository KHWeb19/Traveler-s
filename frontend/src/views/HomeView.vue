<template>
	<div class="home_wrap">
		<section id="theme_search">
			<div class="inner">
				<h1>테마검색</h1>

				<div class="theme">
					<article>
						<div class="pic">					
							<p>#공항근처</p>
						</div>
					</article>
					<article>
						<div class="pic">							
							<p>#반려동물</p>
						</div>
					</article>
					<article>
						<div class="pic">
							<p>#조식</p>
						</div>
					</article>
					<article>
						<div class="pic">					
							<p>#오션뷰</p>
						</div>
					</article>
					<article>
						<div class="pic">					
							<p>#풀빌라</p>
						</div>
					</article>
					<article>
						<div class="pic">						
							<p>#바베큐그릴</p>
						</div>
					</article>
					<br>
					<article>
						<div class="pic">						
							<p>#무료주차</p>
						</div>
					</article>
					<article>
						<div class="pic">						
							<p>#팬션</p>
						</div>
					</article>
					<article>
						<div class="pic">						
							<p>#스키장</p>
						</div>
					</article>
					<article>
						<div class="pic">						
							<p>#온천</p>
						</div>
					</article>
					<article>
						<div class="pic">						
							<p>#특급호텔</p>
						</div>
					</article>

				</div>
			</div>
		</section>
	</div>
</template>

<script>

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
