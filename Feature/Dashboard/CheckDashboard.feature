
Feature: Check the dashboard

Scenario Outline: Check the default display of dashboard
Given Login to the CAM "<username>" "<password>"
  Then Check the default checked radio
  Then Check the total unread records "<unreadmessage>"
	Then Check all the status of first page
	Then Check all the status of last page
  Then Click the all radio
	Then check the total records "<totalmessage>"


Examples:
    |username|password|unreadmessage|totalmessage|
    | 1000001@qq.com |test|select * from cad_message where client_id in((select client_id from cad_kund_vert_vekl where (kuvk_vert1nr=(select cad_user_sm from cad_configurations where lr_userid=11519)) or (kuvk_vert1nr in (select adv_sm from cad_smfilter where lr_userid=11519) and client_id in (select client_id from cad_kunden where KundFili in (select dep_kundfili from cad_depfilter where lr_userid=11519))))) and mssg_status=1|select * from cad_message where client_id in((select client_id from cad_kund_vert_vekl where (kuvk_vert1nr=(select cad_user_sm from cad_configurations where lr_userid=11519)) or (kuvk_vert1nr in (select adv_sm from cad_smfilter where lr_userid=11519) and client_id in (select client_id from cad_kunden where KundFili in (select dep_kundfili from cad_depfilter where lr_userid=11519)))))|