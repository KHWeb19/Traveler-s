import axios from "axios"
import router from "../router/index.js"

axios.interceptors.request.use((config) =>
    
    {
        if (localStorage.getItem("access_token")){
            config.headers.common['Authorization'] = `Bearer ${localStorage.getItem("access_token")}`
            console.log("Seding a request")
        }
        return config
    },

    (error) => {
        return Promise.reject(error)
    }
    
)


axios.interceptors.response.use((response)=>{return response}, async (error) => 
    {

        const originalRequest = error.config

        if (error.response.status === 401 && !originalRequest._retry && localStorage.getItem("access_token")){
            originalRequest._retry = true
        
            const {status,data} = await axios.post('http://localhost:7777/refreshtoken', {}, {withCredentials: true})
            console.log("Sending a request for refresh token")
            if (status === 200){
                localStorage.setItem("access_token", data.access_token)
                originalRequest.headers['Authorization'] = `Bearer ${data.access_token}`
                return axios(originalRequest)
            }
        }
        else if (error.response.status === 403){
            alert("해당 요청에 대한 권한이 없습니다")
            router.push({name:"home"})
        }
    console.log("End of response interceptor ", error)    
    return error    
    }
    
)
