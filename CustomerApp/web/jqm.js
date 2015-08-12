var blogsItemTemplate = Handlebars.compile($("#blogs-item-template").html());
var data = [3];
var count = 0;
var a;
var source;
var hash = window.location.hash.substring(1);
//$(document).ready(function(){
//    $("input").focus(function(){
//        $(this).css("background-color", "#cccccc");
//    });
//    $("input").blur(function(){
//        $(this).css("background-color", "#ffffff");
//    });
//});

//$(document).ready(function(){
//$.getJSON("/customer/Cards")
//            .done(function(result) {
//                for (var i in result)
//             if(result.result == "true"){
//                $("#blogs").append(blogsItemTemplate({
//                    img_url: result[i].img_url,
//                    img_id:result[i].img_id
//                }));}
//            }).fail(function() {
//                console.log("Not found");
//            })
//        });


//
//$(function() {
//    $("#Submit").on("click", function() {
//        $.getJSON("Cards/comeback?id1="+data[0]+"&id2="+data[1]+"&id3="+data[2])
//            .done(function(result){
//                console.log(result)
//                if(result.result == "false"){
//                $('li').remove('#'+data[0]);
//                $('li').remove('#'+data[1]);
//                $('li').remove('#'+data[2]);}
//            }).fail(function() {
//                console.log("Not found");
//            })
//        });
//    })
//    
//
//$(document).on("pagecreate",function(){
//    console.log("ready")
//    source = new EventSource("api/gameroom");
//    console.log("in func")
//    source.onmessage = function(event)
// {
//     console.log("in event"+event);
//     $(document).ready(function(){
//     $.get("Cards").done(function(result){
//            console.log("in cards");
//        });
//     var result = JSON.parse(event.data);
//     console.log(result);
//            (function(result) {
//               // console.log("hi bro")
//                //for (var i in result)
//                $("#blogs").append(blogsItemTemplate({
//                    img_url: result[i].img_url,
//                    img_id: result[i].img_id
//                }));//}
//            }).fail(function() {
//                //console.log("Not found");
//            })
//    }
//})
//
//});
////        
//var result = true;
//  $(function(){     
//          $("#Submit").on("click",function(){
//            $.get("Cards/comeback?id1="+data[0]+"&id2="+data[1]+"&id3="+data[2])
//            .done(function(result){
//                if(result.Result === "true"){
//                    a=result.Result;
//                $('li').remove('#'+data[0]);
//                $('li').remove('#'+data[1]);
//                $('li').remove('#'+data[2]);}
//            }).fail(function() {
//                console.log("Not found");
//            })
//          $.get("/customer/Cards/two")
//            .done(function(result) {
//              if(a === "true"){
//                for (var i in result)
//                $("#blogs").append(blogsItemTemplate({
//                    img_url: result[i].img_url, 
//                    img_id:result[i].img_id
//                }));}
//        });
//    })
//  })
 
//   $("#Submit").on("click",function(){
//              $.getJSON("Cards/comeback?id1="+data[0]+"&id2="+data[1]+"&id3="+data[2])
//            .done(function(result){
//                console.log(result)
//                if(result.result == "true"){
//                $('li').remove('#'+data[0]);
//                $('li').remove('#'+data[1]);
//                $('li').remove('#'+data[2]);}
//            }).fail(function() {
//                console.log("Not found");
//            })
//        });

 
//   $(function() {
//    $("#Submit").on("click", function() {
//        $.getJSON("/customer/Cards" + $("#Score").val())
//       
//        });
//})

//
//var source = null;
//$(function() {
//    $("#startBtn").on("click", function() {
//       source = new EventSource("api/counter?start=" + $("#startNum").val());
//       source.onmessage = eventHandler;
//    });
//});
//
//function eventHandler(event) {
//    console.log("event = " + JSON.stringify(event));
//    $("#counter").text(event.data);
//}

$(document).on("click", ".list img", function() { 
     var id = ($(this).attr('id'));
     if(count>2){
         count = 0;
     }
     if(id != data[0] && id != data[1] && id != data[2])
     {
        data[count] =id;
        count = count + 1;
     }
     console.log(data);
}); 
//
$(function(){
     console.log("in func 2 first ready")
    source = new EventSource("api/gameroom");
    source.addEventListener("" + hash, function(event){
        var chat = JSON.parse(event.data);
        console.log(JSON.stringify(chat));
            $("#blogs").empty();
       for (var i in chat)
                $("#blogs").append(blogsItemTemplate({
                    img_url: chat[i].img_url,
                    img_id: chat[i].img_id
                }));
       
    });
    /*
    source.onmessage = function(event){
        var chat = JSON.parse(event.data);
        console.log(JSON.stringify(chat));
        console.log("in b"+b)
            $("#blogs").empty();
       for (var i in chat)
                $("#blogs").append(blogsItemTemplate({
                    img_url: chat[i].img_url,
                    img_id: chat[i].img_id
                }));
       
    } */

   
          $("#Submit").on("click",function(){
            $.get("Cards/comeback?uid="+hash+"&id1="+data[0]+"&id2="+data[1]+"&id3="+data[2],{})
            .done(function(result){
                console.log(result)
                $("#blogs").empty();
                for (var i in result){
                $("#blogs").append(blogsItemTemplate({
                    img_url: result[i].img_url, 
                    img_id: result[i].img_id
                }));
       }
    })
    });
      
  // $("#sendBtn").on("click",function(){
   $(document).ready(function(){
       console.log(">>> second ready: " + hash);
        $.get("Cards?uid="+hash,{
        }).done(function(){
           // $("msg").val("");
        });
    })
});



    //    
//      $(function(){     
//          $("#Submit").on("click",function(){
//            $.get("Cards/comeback?id1="+data[0]+"&id2="+data[1]+"&id3="+data[2])
//            .done(function(result){
//                b = "result";
//                console.log("in b"+b);
//                if(result.Result === "true"){
//                $('li').remove('#'+data[0]);
//                $('li').remove('#'+data[1]);
//                $('li').remove('#'+data[2]);}
//            }).fail(function() {
//                console.log("Not found");
//            })
//          $.get("/customer/Cards/two")
//            .done(function(result) {
//              if(a === "true"){
//                for (var i in result)
//            
//                $("#blogs").append(blogsItemTemplate({
//                    img_url: result[i].img_url, 
//                    img_id:result[i].img_id
//                }));}
//        });
//    })
//  })
