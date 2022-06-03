<template>
	<footer id="footer">
		<div class="inner">
			<div class="fl">
				<p>
					사업자 정보
					since 2022 어쩌고 저쩌고...우리 회사의 간단한 소개가 적혀있다.. 고객문의: 010-0000-0000 / Email: 0000@gamil.com
				</p>
				<div class="copyRight">사업자 정보 추가사항 블라 블라~</div>
			</div>
			<div class="fr">
				<div class="customer">
					<P></P>
				</div>
				<ul class="sns">
					<li>
						<router-link to=""><v-icon>mdi-facebook</v-icon></router-link>
					</li>
					<li>
						<router-link to=""><v-icon>mdi-instagram</v-icon></router-link>
					</li>
					<li>
						<router-link to=""><v-icon>mdi-youtube</v-icon></router-link>
					</li>
				</ul>
			</div>
		</div>
	</footer>
</template>

<script>
  export default {
    name: "MainFooter"
  }
</script>

<style scoped>
	#footer {
		background: #fff;
		position: relative;
		transition: 0.5s;
		border-top: 1px dashed #fff;
		padding: 30px 80px;
		bottom: -50px;
	}

	#footer:after, #footer .inner:after {
		content: "";
		display: block;
		clear: both;
	}

	#footer .inner {
		width: 1200px;
		margin: 0 auto;
		position: relative;
	}

	#footer .inner .fl {
		float: left;
	}

	#footer .inner .fl ul::after {
		content: '';
		clear: both;
		display: block;
	}

	#footer .inner .fl ul li {
		float: left;
	}

	#footer .inner .fl ul li:not(:last-of-type) {
		margin-right: 40px; }

	#footer .inner .fl ul li a {
		font-size: 15px;
		border-bottom: 1px solid #666;
		color: rgb(0, 0, 0);
	}

	#footer .inner .fl p {
		line-height: 25px;
		font-size: 15px;
		margin: 22px 0;
	}

	#footer .inner .fl .copyRight {
		font-size: 15px;
	}

	#footer .inner .fr {
		float: right;
	}

	#footer .inner .fr p {
		font-size: 15px;
		line-height: 25px;
	}

	#footer .inner .fr p em {
		font-size: 22px;
		font-style: normal;
		font-weight: 600;
	}

	#footer .inner .fr .sns {
		margin-top: 30px;
	}

	#footer .inner .fr .sns li {
		float: left;

	}

	#footer .inner .fr .sns li:not(:last-of-type) {
		margin-right: 30px;
	}

	#footer .inner .fr .sns li i {
		font-size: 45px;
		color: rgba(47, 114, 202, 0.89);
	}

</style>