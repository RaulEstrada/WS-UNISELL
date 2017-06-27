using MIW.Bot.WebApi.DataAccessWS;
using MIW.Bot.WebApi.identityWS;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Threading.Tasks;
using System.Web.Http;
using Telegram.Bot;
using Telegram.Bot.Types;

namespace MIW.Bot.WebApi.Controllers
{
    public class WebHookController : ApiController
    {
        public static readonly ITelegramBotClient BotClient = new TelegramBotClient("379252222:AAFCb6UGqSdZVnVIAjt2kZn6d2q1Su6Nps0");

        [HttpPost]
        public async Task<IHttpActionResult> Post(Update update)
        {
            if (update != null)
            {
                var message = update.Message;
                if (message.Text.StartsWith("/count"))
                {
                    await BotClient.SendTextMessageAsync(message.Chat.Id, new Random().Next().ToString());
                }
                else if (message.Text.StartsWith("/authenticate"))
                {
                    await authenticate(message);
                }
                else if (message.Text.StartsWith("/listorders"))
                {
                    await listOrders(message);   
                }
                else
                {
                    await BotClient.SendTextMessageAsync(message.Chat.Id, "Echo otro " + message.Text);
                }
                
            }
            return Ok();
        }

        private async Task<bool> authenticate(Message message)
        {
            string[] parts = message.Text.Split(new char[0]);
            if (parts.Length != 3)
            {
                await BotClient.SendTextMessageAsync(message.Chat.Id, "Authentication command format: /authenticate username password");
                return false;
            }
            else
            {
                DataAccessSoapClient ws = new DataAccessSoapClient();
                string token = ws.Login(parts[1], parts[2], new DataAccessWS.UserRole[1] { DataAccessWS.UserRole.BUYER });
                if (string.IsNullOrEmpty(token))
                {
                    await BotClient.SendTextMessageAsync(message.Chat.Id, "Invalid authentication data");
                    return false;
                }
                else
                {
                    await BotClient.SendTextMessageAsync(message.Chat.Id, "Auth token: " + token);
                    return true;
                }
            }
        }

        private async Task<bool> listOrders(Message message)
        {
            string[] parts = message.Text.Split(new char[0]);
            if (parts.Length != 2)
            {
                await BotClient.SendTextMessageAsync(message.Chat.Id, "Listorders command format: /listorders authToken");
                return false;
            }
            else
            {
                string authToken = parts[1];
                IdentityWSSoapClient iWS = new IdentityWSSoapClient();
                IdentityData identity = null;
                try
                {
                    identity = iWS.GetIdentity(new identityWS.Security { BinarySecurityToken = authToken });
                }
                catch (Exception ex)
                {
                    await BotClient.SendTextMessageAsync(message.Chat.Id, "An error occurred " + ex.Message);
                    return false;
                }
                if (identity != null)
                {
                    DataAccessSoapClient ws = new DataAccessSoapClient();
                    OrderData[] orders = ws.FindOrdersByUsername(new DataAccessWS.Security { BinarySecurityToken = authToken }, identity.Username);
                    string response = "";
                    foreach (var o in orders)
                    {
                        response += "{" + o.OrderNumber + "} " + o.DateCreated.ToShortDateString() +
                            " [" + o.State.ToString() + "]\n";
                    }
                    await BotClient.SendTextMessageAsync(message.Chat.Id, response);
                    return true;
                }
                return false;
            }
        }
    }
}
