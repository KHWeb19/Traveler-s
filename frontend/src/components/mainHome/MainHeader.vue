<template>
	<v-card width="100%">
		<v-toolbar dense width="1200px">
			<div>
				<v-btn  text plain route :to="{ name: 'Home' }">
					<h1>traveler-s 로고 자리</h1>
				</v-btn>
			</div>

			<v-spacer></v-spacer>

			<ul class="navbar_gnb">
				<li v-if="!this.$store.state.isLogin || this.$store.state.isLogin === false">
					<router-link to="/login">로그인</router-link>
					<router-link to="/signup">회원가입</router-link>
				</li>
				<li v-else>
					<div class="loginUser"><span>{{nickName}}</span>님</div>
					<router-link to="/mypage">내정보</router-link>
					<button @click="onClickLogout">로그아웃</button>
				</li>
			</ul>
		</v-toolbar>
	</v-card>
</template>

<script>
  export default {
    name: "MainHeader",
    data() {
      return {
        nickName: this.$store.state.userInfo.nickname,
        isLogin: undefined,
      }
    },
    mounted() {
      this.isLogin = this.$store.state.isLogin;
    },
    methods: {
      onClickLogout() {
        this.$store.dispatch("logout")
        this.$router.push({name: "Home"});
      },
    },
  }
</script>


<style scoped>
	.v-card {
		padding: 15px 0;
	}

	.v-sheet.v-card:not(.v-sheet--outlined) {
		box-shadow: none;
		border-bottom: 1px solid #fff;
	}


	.v-card > *:last-child:not(.v-btn):not(.v-chip):not(.v-avatar) {
		border-radius: 0;
	}


	.v-sheet.v-toolbar:not(.v-sheet--outlined) {
		box-shadow: none;
	}

/* 로고 들어가면 빠짐 */ 
	.v-toolbar__title a {
		font-size: 30px;
		color: rgb(0, 0, 0);
		font-family: 'Poor Story', cursive;
		font-weight: bold;
	}

	.v-toolbar__content > .v-tabs, .v-toolbar__extension > .v-tabs {
		width: 70%;
		padding: 0 200px;
	}

	.navbar_gnb {
		display: flex;
	}

	.navbar_gnb li {
		padding: 8px 5px;
		font-size: 11px;
		font-family: 'Gowun Dodum', sans-serif;
		font-weight: bold;
	}

	.navbar_gnb li a {
		color: rgb(0, 0, 0);
		float: left;
	}

	.navbar_gnb li a:nth-of-type(1) {
		margin-right: 7px;
	}

	.navbar_gnb li .loginUser {
		font-size: 13px;
	}

	.navbar_gnb li .loginUser > span {
		background: linear-gradient(to top, #ffffff 50%, transparent 50%);
	}

	.v-application ul, .v-application ol {
		padding-left: 0;
	}

	.v-tabs:not(.v-tabs--vertical) .v-tab a {
		font-family: 'Gowun Dodum', sans-serif;
		font-weight: bold;
		font-size: 14px;
		color: #222;
		display: block;
		
	}

	.v-tab a {
		display: block;
		padding: 10px 15px;
	}

</style>