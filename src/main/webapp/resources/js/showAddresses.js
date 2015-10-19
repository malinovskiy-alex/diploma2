var map = new GMaps({
    div: '#map',
    lat: 49.991932,
    lng: 36.218886
});

$.ajax({
    url:'/clusters',
    success:function(result){
        _.groupBy(result,function(model){
            return model.clusterId
        })

        /*for(var i=0;i<26;i++){
            if(i>0){
         map.addMarker({
         lat: result[i].lat,
         lng: result[i].lng,
         title: result[i].name,
         icon:'../../../resources/images/Google Maps Markers/darkgreen_MarkerG.png'
         });
            }
        }*/
        for(var i=26;i<result.length;i++){
            if(i>27){
                map.addMarker({
                    lat: result[i].lat,
                    lng: result[i].lng,
                    title: result[i].name,
                    icon:'../../../resources/images/Google Maps Markers/blue_MarkerA.png'
                });

            }
        }

       /*- _.each(result,function(model){

            map.drawRoute({
                origin: [49.991932, 36.218886],
                destination: [49.975815, 36.268525],
                travelMode: 'driving',
                strokeColor: '#131540',
                strokeOpacity: 0.6,
                strokeWeight: 4
            });
            if(model.clusterId===1){
                map.addMarker({
                    lat: model['lat'],
                    lng: model['lng'],
                    title: model['name'],
                    icon:'../../../resources/images/Google Maps Markers/darkgreen_MarkerG.png'
                });
            }else if(model.clusterId===2){
                map.addMarker({
                    lat: model['lat'],
                    lng: model['lng'],
                    title: model['name'],
                    icon:'../../../resources/images/Google Maps Markers/blue_MarkerA.png'
                });
            }
        })*/
    }
})