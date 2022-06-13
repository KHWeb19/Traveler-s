<script>
import Vue from 'vue'
import cookies from 'vue-cookies'

Vue.use(cookies)

export default {
    name: 'OAuth2Redirect',
    data () {
        return {
            access_token:'',
            refresh_token:''

        }
    },
    mounted () {
        localStorage.setItem("access_token", this.$route.query.access_token)
        this.$cookies.set("refresh_token", this.$route.query.refresh_token, 60 * 60 * 24 * 14)
        if(localStorage.getItem("access_token") != null){
        this.$router.go(-2)}
    }
}
</script>