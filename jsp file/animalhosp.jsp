<html>
<head>
<meta charset="UTF-8">
    <title>Hospital List</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
<div class='container'>
  <div class='row'>
    <!-- Left Column - Hospital List -->
<div class='col-md-5'>
      <h2>Hospital List</h2>
      <table id="hospitalTable" class="table table-hover">
        <thead>
          <tr>
            <th>No</th>
            <th>Name</th>
            <th>latitude</th>
            <!-- Add other table headers here -->
          </tr>
        </thead>
        <tbody></tbody> 
      </table>

      <!-- Paging -->
      <div class="row">
        <div class="col-lg-12">
          <div class="pull-right">
            <ul id="pagination" class="pagination">
              <!-- Pagination links will be added dynamically by JavaScript -->
            </ul>
          </div>
        </div>
      </div><!-- End Paging --> 
    </div><!-- End Left Column -->

   <!-- Right Column - Map 영역 --> 
   <div class="col-md-7">
    	<h2>Map</h2>

    	<!-- The div where your map will be displayed -->
    	<div id="map" style="width:100%;height:600px;"></div>
  	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=324cb7fd34303372c49d32287955fde6&libraries=services"></script>
  	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=324cb7fd34303372c49d32287955fde6"></script>
  		<script>	
			var container = document.getElementById('map');
			var options = {
				center: new kakao.maps.LatLng(37.557192, 126.924529),
				level: 3
			};
			var map = new kakao.maps.Map(container, options);		
			// Add markers to the map
			// You need to implement this part based on your hospital data
  		</script>
<!-- Bootstrap JS (Optional)-->
<script src= "https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<!-- Ajax Script-->
<script type="text/javascript">
$(document).ready(function() {
    function loadHospitalData(pageNum) {
        $.ajax({
            url: "/animalhosp/list",
            method: "GET",
            dataType: 'json', 
            data: { 
                pageNum: pageNum,
                amount: 10
            },
            success:function(response){
                console.log(response);
                var hospitals = response.hospitals; 
                console.log(hospitals);
                 var pageMaker = response.pageMaker;
                 var start = pageMaker.start;
                 var end = pageMaker.end;
                 var prev = pageMaker.prev;
                 var next = pageMaker.next;
                 console.log(start, end, prev, next);

                  $("#hospitalTable tbody").empty();
                  for(var i=0;i<hospitals.length;i++){
                      //table
                  	  let tr=document.createElement('tr');
                      tr.innerHTML="<td>"+hospitals[i]['animalhosp_no']+"</td>"+
                      "<td>"+hospitals[i]['animalhosp_name']+"</td>"+
                      "<td>"+hospitals[i]['a_latitude']+"</td>";              
                      $("#hospitalTable tbody").append(tr);
                  }
                  //paging chapter
                  $("#pagination").empty();
                  if (prev) {
                      $("#pagination").append('<li class="page-item"><a href="#" class="page-link" data-page="' + (start - 1) + '">&laquo; Previous</a></li>');
                  }              
                  for (var i=start; i<=end; i++) {
                      let activeClass=i===pageNum?'active':'';
                      $("#pagination").append('<li class="page-item '+activeClass+'"><a href="#" class="page-link" data-page="' +i+'">'+i+'</a></li>');
                   }
                   if(next){
                       $("#pagination").append('<li class="page-item"><a href="#" class="page-link" data-page="' +(end+1)+'">Next &raquo;</a></li>');
                   }
            },
            error:function(xhr,status,error){
               console.error(error);
            }
        });
    }
    loadHospitalData(1);
    $(document).on('click', '#pagination a', function(e) {
        e.preventDefault();
        var pageNum = $(this).data('page');
        loadHospitalData(pageNum);
    });
});
</script>
<!-- Ajax Script End -->
  </div> 
 </div><!-- End Row -->
</div><!-- End Container -->
</body>
</html>