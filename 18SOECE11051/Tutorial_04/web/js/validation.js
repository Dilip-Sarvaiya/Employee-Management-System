$(document).ready(function(){
			$("form").submit(function(){
				$("#error1").remove();
                                
				var  Name=$("#name").val();
				var  Email=$("#email").val();
				var  Salary=$("#salary").val();
				var  Age=$("#age").val();
				var  Department=$("#department").val();
                                
                               
				
				if(Email=="" || Salary=="" || Age=="" 
				|| Department=="" || Name=="")
				{	
                                        if(Name=="")
					{
						$("#p6").html("Name is required");
						$("#p6").css({"color":"red"});
					}
					if(Email=="")
					{
						$("#p1").html("<p id='error1'>Email is required</p>");
						$("#p1").css({"color":"red"});
					}
					if(Salary=="")
					{
						$("#p2").html("Password is required");
						$("#p2").css({"color":"red"});
					}
					if(Age=="")
					{
						$("#p4").html("Age is required");
						$("#p4").css({"color":"red"});
					}
					if(Department=="")
					{
						$("#p5").html("Birthday is required");
						$("#p5").css({"color":"red"});
					}
                                        return false;
                                    }
                                    else
                                    {
                                        return true;
                                    }
                            });
                             $("#name").keyup(function(){
				var name=$("#name").val();
				
				if(name!="")
				{
					if(name.length>2)
					{
						$("#p6").html("Name is confirmed");
						$("#p6").css({"color":"yellow"});
					}
					else
					{
						$("#p6").html("Not a valid name!");
						$("#p6").css({"color":"red"});
					}
				}
				else
				{
					$("#p6").html("Name is not confirmed");
					$("#p6").css({"color":"red"});
				}
			});
                              $("#email").keyup(function(){
				var Email=$("#email").val();
				if(Email!="")
				{
					
					var regEx = /^([\w-\.]+@([\w-]+\.)+[\w-]{2,4})?$/;
					var validEmail = regEx.test(Email);
					if (!validEmail) 
					{
							$("#p1").html("Email is not valid");
							$("#p1").css({"color":"red"});
					}
					else
					{
							$("#p1").html("Email is Valid");
							$("#p1").css({"color":"yellow"});
					}
				}
				else
				{
					$("#p1").html("Email is not Valid");
					$("#p1").css({"color":"red"});
					
				}
			});
                        $("#salary").keyup(function(){
				var Salary=$("#salary").val();
				
				if(Salary!="")
				{
					if(Salary.length>2)
					{
						$("#p2").html("Salary is confirmed");
						$("#p2").css({"color":"yellow"});
					}
					else
					{
						$("#p2").html("Salary must be greater than 2 digits");
						$("#p2").css({"color":"red"});
					}
				}
				else
				{
					$("#p2").html("Salary is not confirmed");
					$("#p2").css({"color":"red"});
				}
			});
			$("#age").keyup(function(){
				var Age=$("#age").val();
				
				if(Age!="")
				{
					if(Age>=18)
					{
						$("#p4").html("Age is confirmed");
						$("#p4").css({"color":"yellow"});
					}
					else
					{
						$("#p4").html("Age must be greater than 18");
						$("#p4").css({"color":"red"});
					}
				}
				else
				{
					$("#p4").html("Age is not valid");
					$("#p4").css({"color":"red"});
					
				}
			});
                       $("#department").keyup(function(){
				var Department=$("#department").val();
				
				if(Department!="")
				{
					$("#p5").html("Department is confirmed");
					$("#p5").css({"color":"yellow"});
					
				}
				else
				{
					$("#p5").html("Department is not valid");
					$("#p5").css({"color":"red"});
				}
			});
                       
                        
                    });