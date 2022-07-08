<template>
    <div>
        <div id="map" style="width:70%;height:400px;"></div>
    </div>
    
</template>

<script>
export default {
    name: 'KakaoMap',
    props : {
        mHotel:{
            type: Object,
            required: true
        }
    },
    data() {
        return{
            map: null,
            geocoder: null,
            hotelInfo: [],
}
    },
    methods: {
        initMap() {
            const container = document.getElementById("map")
            const options = {
                center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
                level: 3, // 지도의 확대 레벨
            }
            const map = new kakao.maps.Map(container, options)
            this.geocoder = new kakao.maps.services.Geocoder()
         
            const hotel = this.mHotel
            this.geocoder.addressSearch(hotel.totalAddress, function(result, status) {
                if (status === kakao.maps.services.Status.OK) {
                      
                    const coords = new kakao.maps.LatLng(result[0].y, result[0].x)
                    
                    // 결과값으로 받은 위치를 마커로 표시합니다
                    const marker = new kakao.maps.Marker({
                        map,
                        position: coords
                    })

                    // 인포윈도우로 장소에 대한 설명을 표시합니다
                    const infowindow = new kakao.maps.InfoWindow({
                       
                        content: `<div style="width:150px;text-align:center;padding:6px 0;">${hotel.hotelName} </div>`
                    })
                    infowindow.open(map, marker)

                    // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
                    map.setCenter(coords)
                } 
            })
        },
        kakao () {
                if(!window.kakao || !window.kakao.maps){
                    const script = document.createElement("script")
                    /* global kakao */
                    script.onload = () => kakao.maps.load(this.initMap);
                    script.src= "https://dapi.kakao.com/v2/maps/sdk.js?appkey=ec61fc18851964c845de3db938cfd080&libraries=services&autoload=false"
                    document.head.appendChild(script);
                
                    }else{
                        this.initMap()
                    }
                    return

        }
    },

    mounted () {
            this.$watch('mHotel', function(){
                this.kakao()
                return
            })
            this.kakao()      
    }
    /*watch: {
        mHotel: function() {
            if(!window.kakao || !window.kakao.maps){
                const script = document.createElement("script")*/
                
              /*  script.onload = () => kakao.maps.load(this.initMap);
                script.src= "https://dapi.kakao.com/v2/maps/sdk.js?appkey=ec61fc18851964c845de3db938cfd080&libraries=services&autoload=false"
                document.head.appendChild(script);
            }else{
                this.initMap()
            }
        }
    }*/
}
</script>