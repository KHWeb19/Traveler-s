<script>
import Vue from 'vue'
import cookies from 'vue-cookies'

Vue.use(cookies)

export default {
    name: 'OAuth2Redirect',
    mounted () {
        localStorage.setItem("access_token", this.$route.query.access_token)
        if(localStorage.getItem("access_token") != null){
            this.$router.push("/")
        //this.$router.go(-2)
        }
    }
}
</script>