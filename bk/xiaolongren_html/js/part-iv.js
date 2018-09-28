(function(){
  //each droppable element needs this for its dragover event
  var allowDragover = function (event) {
    //prevent the browser from any default behavior
    event.preventDefault();
  },
  //each dragable element needs this for its dragstart event
  dragStartHandler = function (event) {
    var dragIcon = null;

    //set a reference to the element that is currenly being dragged
    event.originalEvent.dataTransfer.setData("id",event.target.id);

    //create a custom drag image
    dragIcon = document.createElement('img');
    dragIcon.src = 'http://bit.ly/bartSimpsonSkateboard200X200';

    //set the custom drag image
    event.originalEvent.dataTransfer.setDragImage(dragIcon, 100, 100); 
  },
  //each of the four light-brown boxes at top have this bound to their drop event
  dropHandlerSingle = function (event) {
    var id = '';

    //prevent the browser from any default behavior
    event.preventDefault();

    //only allow one child element at a time
    if($(this).children().length){return;}

    //get a reference to the element that is being dropped
    id = event.originalEvent.dataTransfer.getData("id");
    
    //add the hasChild class so that the UI can update
    $(event.target).addClass('hasChild');

    //trigger the custom event so that we can update the UI
    $(document).trigger('custom:dropEvent');

    //move the dragged element into the drop target
    event.target.appendChild(document.getElementById(id));
  },
  //the box that holds the four blue dragable boxes on page load has this bound to its drop event
  dropHandlerMultiple = function (event) {
    event.preventDefault();

    var id = event.originalEvent.dataTransfer.getData("id");

    $(event.target).addClass('hasChild');

    event.target.appendChild(document.getElementById(id));

    $(document).trigger('custom:dropEvent');
  };

  $(document).ready(function(){
    //cache a reference to all four blue draggable boxes
    var $dragElements = $('.dragElement');

    //make each dragElement draggable
    $dragElements.attr('draggable','true');

    //bind the dragStartHandler function to all dragElements
    $dragElements.bind('dragstart',dragStartHandler);

    //bind the dropHandlerSingle function to all of the droppable elements (omit the original container)
    $('.droppable').not('.multipleChildren').bind('drop',dropHandlerSingle);

    //bind the dropHandlerMultiple function to the .droppable.multipleChildren element
    $('.droppable.multipleChildren').bind('drop',dropHandlerMultiple);

    //after something is dropped
    $(document).on('custom:dropEvent',function(){
      //make sure the DOM has been updated
      setTimeout(function(){
        //check each droppable element to see if it has a child
        $('.droppable').each(function(){
          //if this element has no children
          if (!$(this).children().length){
            //remove the hasChild class
            $(this).removeClass('hasChild');
          }
        });
      },50);
    });

    //bind the appropriate handlers for the dragover, dragenter and dragleave events
    $('.droppable').bind({
      dragover: allowDragover,
      dragenter: function() {
        //ignore this event for the original container of the drag elements
        if ( $(this).hasClass('multipleChildren') ){return;}

        $(this).addClass('dragEnter');
      },
      dragleave: function() {
        $(this).removeClass('dragEnter');
      }
    });
  })
})();