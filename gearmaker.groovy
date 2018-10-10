//Your code here

File servoFile = ScriptingEngine.fileFromGit(
	"https://github.com/sonchika/gear_d_shaft_12.git",
	"12_TOOTH_GEAR_D_SHAFT_BOWLER.STL");
// Load the .CSG from the disk and cache it in memory

CSG gear  = Vitamins.get(servoFile)
			.toZMin()
			.toXMin()
			.toYMin()
double totalX = gear.getTotalX()
println "X dim "+totalX
double totalY = gear.getTotalY()
println "Y dim "+totalY

gear=gear
	.movex(-totalX/2)
	.movey(-totalX/2)

CSG myDShaft = Vitamins.get("dShaft","WPI-gb37y3530-50en");

myDShaft=myDShaft.union(myDShaft.movez(myDShaft.getTotalZ()))
gear=gear.difference(myDShaft)


return [gear]