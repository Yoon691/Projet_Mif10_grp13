<script src="../js/calendrier.js"></script>
<link rel="stylesheet" type="text/css" href="../css/calendrier.css" />

<div id="calendarMain" class="calendarMain"></div>
<script type="text/javascript">
//<![CDATA[
var myCalendar = new jsSimpleDatePickr();
myCalendar.CalAdd({
'divId': 'calendarMain',
'dateMask': 'JJ/MM/AAAA',
'dateCentury': 20,
'titleMask': 'M AAAA',
'navType': '01',
'classTable': 'jsCalendar',
'classDay': 'day',
'classDaySelected': 'selectedDay',
'monthLst': ['Janvier', 'Février', 'Mars', 'Avril', 'Mai', 'Juin', 'Juillet', 'Août', 'Septembre', 'Octobre', 'Novembre', 'Décembre'],
'dayLst': ['D', 'L', 'M', 'M', 'J', 'V', 'S'],
'hideOnClick': false,
'showOnLaunch': true
});
//]]>
</script>