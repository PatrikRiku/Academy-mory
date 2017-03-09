/**
 * Created by Administrator on 2017-03-08.
 */
var memory_values = [];
var memory_tile_ids = [];
var tiles_flipped = 0;
var numberOfClicks = 0;
function clickTime(divid, image_pk, boardSize) {


    if (memory_values.length <2) {
        document.getElementById(divid).style.opacity = 0;
        numberOfClicks += 2;
        if (memory_values.length == 0) {
            memory_values.push(image_pk);
            memory_tile_ids.push(divid);
        } else if (memory_values.length == 1) {
            memory_values.push(image_pk);
            memory_tile_ids.push(divid);
            if (memory_values[0] == memory_values[1]) {
                tiles_flipped += 2;
                // Clear both arrays
                memory_values = [];
                memory_tile_ids = [];
                // Check to see if the whole board is cleared
                if (tiles_flipped == boardSize) {
                    function winner() {
                        alert("We did it TEAM!\n You clicked: " + numberOfClicks + " times");
                        window.location.reload()
                    } setTimeout(winner, 3000);

                }
            } else {
                function flip2Back() {
                    document.getElementById(memory_tile_ids[0]).style.opacity = 1;
                    document.getElementById(memory_tile_ids[1]).style.opacity = 1;
                    // Flip the 2 tiles back over
                    // var tile_1 = document.getElementById(memory_tile_ids[0]);
                    // var tile_2 = document.getElementById(memory_tile_ids[1]);
                    // tile_1.style.background = 'url(tile_bg.jpg) no-repeat';
                    // tile_1.innerHTML = "";
                    // tile_2.style.background = 'url(tile_bg.jpg) no-repeat';
                    // tile_2.innerHTML = "";
                    // Clear both arrays
                    memory_values = [];
                    memory_tile_ids = [];
                }
                setTimeout(flip2Back, 1000);
            }
        }
    }
}

