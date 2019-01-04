 function EnableDisableLinks(btn) {
            var links = document.getElementsByTagName("a");
            if (btn.value == "deactivate") {
                btn.value = "activate";
                for (var i = 0; i < links.length; i++) {
                    var href = links[i].href;
                    links[i].setAttribute("rel", href);
                    links[i].href = "javascript:;"
                }
            } else {
                btn.value = "deactivate";
                for (var i = 0; i < links.length; i++) {
                    var href = links[i].getAttribute("rel");
                    links[i].removeAttribute("rel");
                    links[i].href = href
                }
            }
   }