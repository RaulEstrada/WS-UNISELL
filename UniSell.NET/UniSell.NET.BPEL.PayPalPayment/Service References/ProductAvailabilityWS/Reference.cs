﻿//------------------------------------------------------------------------------
// <auto-generated>
//     This code was generated by a tool.
//     Runtime Version:4.0.30319.42000
//
//     Changes to this file may cause incorrect behavior and will be lost if
//     the code is regenerated.
// </auto-generated>
//------------------------------------------------------------------------------

namespace UniSell.NET.BPEL.PayPalPayment.ProductAvailabilityWS {
    
    
    /// <remarks/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Xml", "4.6.1586.0")]
    [System.SerializableAttribute()]
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.ComponentModel.DesignerCategoryAttribute("code")]
    [System.Xml.Serialization.XmlTypeAttribute(Namespace="http://ws.unisell.miw.uniovi/")]
    public partial class ProductNotAvailableException : object, System.ComponentModel.INotifyPropertyChanged {
        
        private string messageField;
        
        /// <remarks/>
        [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified, Order=0)]
        public string message {
            get {
                return this.messageField;
            }
            set {
                this.messageField = value;
                this.RaisePropertyChanged("message");
            }
        }
        
        public event System.ComponentModel.PropertyChangedEventHandler PropertyChanged;
        
        protected void RaisePropertyChanged(string propertyName) {
            System.ComponentModel.PropertyChangedEventHandler propertyChanged = this.PropertyChanged;
            if ((propertyChanged != null)) {
                propertyChanged(this, new System.ComponentModel.PropertyChangedEventArgs(propertyName));
            }
        }
    }
    
    /// <remarks/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Xml", "4.6.1586.0")]
    [System.SerializableAttribute()]
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.ComponentModel.DesignerCategoryAttribute("code")]
    [System.Xml.Serialization.XmlTypeAttribute(Namespace="http://ws.unisell.miw.uniovi/")]
    public partial class item : object, System.ComponentModel.INotifyPropertyChanged {
        
        private long productIdField;
        
        private bool productIdFieldSpecified;
        
        private int unitsField;
        
        private bool unitsFieldSpecified;
        
        /// <remarks/>
        [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified, Order=0)]
        public long productId {
            get {
                return this.productIdField;
            }
            set {
                this.productIdField = value;
                this.RaisePropertyChanged("productId");
            }
        }
        
        /// <remarks/>
        [System.Xml.Serialization.XmlIgnoreAttribute()]
        public bool productIdSpecified {
            get {
                return this.productIdFieldSpecified;
            }
            set {
                this.productIdFieldSpecified = value;
                this.RaisePropertyChanged("productIdSpecified");
            }
        }
        
        /// <remarks/>
        [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified, Order=1)]
        public int units {
            get {
                return this.unitsField;
            }
            set {
                this.unitsField = value;
                this.RaisePropertyChanged("units");
            }
        }
        
        /// <remarks/>
        [System.Xml.Serialization.XmlIgnoreAttribute()]
        public bool unitsSpecified {
            get {
                return this.unitsFieldSpecified;
            }
            set {
                this.unitsFieldSpecified = value;
                this.RaisePropertyChanged("unitsSpecified");
            }
        }
        
        public event System.ComponentModel.PropertyChangedEventHandler PropertyChanged;
        
        protected void RaisePropertyChanged(string propertyName) {
            System.ComponentModel.PropertyChangedEventHandler propertyChanged = this.PropertyChanged;
            if ((propertyChanged != null)) {
                propertyChanged(this, new System.ComponentModel.PropertyChangedEventArgs(propertyName));
            }
        }
    }
    
    /// <remarks/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Xml", "4.6.1586.0")]
    [System.SerializableAttribute()]
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.ComponentModel.DesignerCategoryAttribute("code")]
    [System.Xml.Serialization.XmlTypeAttribute(Namespace="http://ws.unisell.miw.uniovi/")]
    public partial class shoppingCart : object, System.ComponentModel.INotifyPropertyChanged {
        
        private double amountField;
        
        private bool amountFieldSpecified;
        
        private string authTokenField;
        
        private long buyerIdField;
        
        private bool buyerIdFieldSpecified;
        
        private item[] itemsField;
        
        private string passwordField;
        
        private bool productsAvailableField;
        
        private string signatureField;
        
        private bool successfulPaymentField;
        
        private string usernameField;
        
        /// <remarks/>
        [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified, Order=0)]
        public double amount {
            get {
                return this.amountField;
            }
            set {
                this.amountField = value;
                this.RaisePropertyChanged("amount");
            }
        }
        
        /// <remarks/>
        [System.Xml.Serialization.XmlIgnoreAttribute()]
        public bool amountSpecified {
            get {
                return this.amountFieldSpecified;
            }
            set {
                this.amountFieldSpecified = value;
                this.RaisePropertyChanged("amountSpecified");
            }
        }
        
        /// <remarks/>
        [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified, Order=1)]
        public string authToken {
            get {
                return this.authTokenField;
            }
            set {
                this.authTokenField = value;
                this.RaisePropertyChanged("authToken");
            }
        }
        
        /// <remarks/>
        [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified, Order=2)]
        public long buyerId {
            get {
                return this.buyerIdField;
            }
            set {
                this.buyerIdField = value;
                this.RaisePropertyChanged("buyerId");
            }
        }
        
        /// <remarks/>
        [System.Xml.Serialization.XmlIgnoreAttribute()]
        public bool buyerIdSpecified {
            get {
                return this.buyerIdFieldSpecified;
            }
            set {
                this.buyerIdFieldSpecified = value;
                this.RaisePropertyChanged("buyerIdSpecified");
            }
        }
        
        /// <remarks/>
        [System.Xml.Serialization.XmlElementAttribute("items", Form=System.Xml.Schema.XmlSchemaForm.Unqualified, IsNullable=true, Order=3)]
        public item[] items {
            get {
                return this.itemsField;
            }
            set {
                this.itemsField = value;
                this.RaisePropertyChanged("items");
            }
        }
        
        /// <remarks/>
        [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified, Order=4)]
        public string password {
            get {
                return this.passwordField;
            }
            set {
                this.passwordField = value;
                this.RaisePropertyChanged("password");
            }
        }
        
        /// <remarks/>
        [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified, Order=5)]
        public bool productsAvailable {
            get {
                return this.productsAvailableField;
            }
            set {
                this.productsAvailableField = value;
                this.RaisePropertyChanged("productsAvailable");
            }
        }
        
        /// <remarks/>
        [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified, Order=6)]
        public string signature {
            get {
                return this.signatureField;
            }
            set {
                this.signatureField = value;
                this.RaisePropertyChanged("signature");
            }
        }
        
        /// <remarks/>
        [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified, Order=7)]
        public bool successfulPayment {
            get {
                return this.successfulPaymentField;
            }
            set {
                this.successfulPaymentField = value;
                this.RaisePropertyChanged("successfulPayment");
            }
        }
        
        /// <remarks/>
        [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified, Order=8)]
        public string username {
            get {
                return this.usernameField;
            }
            set {
                this.usernameField = value;
                this.RaisePropertyChanged("username");
            }
        }
        
        public event System.ComponentModel.PropertyChangedEventHandler PropertyChanged;
        
        protected void RaisePropertyChanged(string propertyName) {
            System.ComponentModel.PropertyChangedEventHandler propertyChanged = this.PropertyChanged;
            if ((propertyChanged != null)) {
                propertyChanged(this, new System.ComponentModel.PropertyChangedEventArgs(propertyName));
            }
        }
    }
    
    /// <remarks/>
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.Xml", "4.6.1586.0")]
    [System.SerializableAttribute()]
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.ComponentModel.DesignerCategoryAttribute("code")]
    [System.Xml.Serialization.XmlTypeAttribute(Namespace="http://ws.unisell.miw.uniovi/")]
    public partial class ArgumentException : object, System.ComponentModel.INotifyPropertyChanged {
        
        private string messageField;
        
        /// <remarks/>
        [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified, Order=0)]
        public string message {
            get {
                return this.messageField;
            }
            set {
                this.messageField = value;
                this.RaisePropertyChanged("message");
            }
        }
        
        public event System.ComponentModel.PropertyChangedEventHandler PropertyChanged;
        
        protected void RaisePropertyChanged(string propertyName) {
            System.ComponentModel.PropertyChangedEventHandler propertyChanged = this.PropertyChanged;
            if ((propertyChanged != null)) {
                propertyChanged(this, new System.ComponentModel.PropertyChangedEventArgs(propertyName));
            }
        }
    }
    
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    [System.ServiceModel.ServiceContractAttribute(Namespace="http://ws.unisell.miw.uniovi/", ConfigurationName="ProductAvailabilityWS.IProductAvailabilityWS")]
    public interface IProductAvailabilityWS {
        
        // CODEGEN: Parameter 'return' requires additional schema information that cannot be captured using the parameter mode. The specific attribute is 'System.Xml.Serialization.XmlElementAttribute'.
        [System.ServiceModel.OperationContractAttribute(Action="http://ws.unisell.miw.uniovi/IProductAvailabilityWS/checkAvailabilityRequest", ReplyAction="http://ws.unisell.miw.uniovi/IProductAvailabilityWS/checkAvailabilityResponse")]
        [System.ServiceModel.FaultContractAttribute(typeof(UniSell.NET.BPEL.PayPalPayment.ProductAvailabilityWS.ProductNotAvailableException), Action="http://ws.unisell.miw.uniovi/IProductAvailabilityWS/checkAvailability/Fault/Produ" +
            "ctNotAvailableException", Name="ProductNotAvailableException")]
        [System.ServiceModel.FaultContractAttribute(typeof(UniSell.NET.BPEL.PayPalPayment.ProductAvailabilityWS.ArgumentException), Action="http://ws.unisell.miw.uniovi/IProductAvailabilityWS/checkAvailability/Fault/Argum" +
            "entException", Name="ArgumentException")]
        [System.ServiceModel.XmlSerializerFormatAttribute(SupportFaults=true)]
        [return: System.ServiceModel.MessageParameterAttribute(Name="return")]
        UniSell.NET.BPEL.PayPalPayment.ProductAvailabilityWS.checkAvailabilityResponse checkAvailability(UniSell.NET.BPEL.PayPalPayment.ProductAvailabilityWS.checkAvailabilityRequest request);
        
        [System.ServiceModel.OperationContractAttribute(Action="http://ws.unisell.miw.uniovi/IProductAvailabilityWS/checkAvailabilityRequest", ReplyAction="http://ws.unisell.miw.uniovi/IProductAvailabilityWS/checkAvailabilityResponse")]
        System.Threading.Tasks.Task<UniSell.NET.BPEL.PayPalPayment.ProductAvailabilityWS.checkAvailabilityResponse> checkAvailabilityAsync(UniSell.NET.BPEL.PayPalPayment.ProductAvailabilityWS.checkAvailabilityRequest request);
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
    [System.ServiceModel.MessageContractAttribute(WrapperName="checkAvailability", WrapperNamespace="http://ws.unisell.miw.uniovi/", IsWrapped=true)]
    public partial class checkAvailabilityRequest {
        
        [System.ServiceModel.MessageBodyMemberAttribute(Namespace="http://ws.unisell.miw.uniovi/", Order=0)]
        [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified)]
        public UniSell.NET.BPEL.PayPalPayment.ProductAvailabilityWS.shoppingCart arg0;
        
        public checkAvailabilityRequest() {
        }
        
        public checkAvailabilityRequest(UniSell.NET.BPEL.PayPalPayment.ProductAvailabilityWS.shoppingCart arg0) {
            this.arg0 = arg0;
        }
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
    [System.ServiceModel.MessageContractAttribute(WrapperName="checkAvailabilityResponse", WrapperNamespace="http://ws.unisell.miw.uniovi/", IsWrapped=true)]
    public partial class checkAvailabilityResponse {
        
        [System.ServiceModel.MessageBodyMemberAttribute(Namespace="http://ws.unisell.miw.uniovi/", Order=0)]
        [System.Xml.Serialization.XmlElementAttribute(Form=System.Xml.Schema.XmlSchemaForm.Unqualified)]
        public UniSell.NET.BPEL.PayPalPayment.ProductAvailabilityWS.shoppingCart @return;
        
        public checkAvailabilityResponse() {
        }
        
        public checkAvailabilityResponse(UniSell.NET.BPEL.PayPalPayment.ProductAvailabilityWS.shoppingCart @return) {
            this.@return = @return;
        }
    }
    
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    public interface IProductAvailabilityWSChannel : UniSell.NET.BPEL.PayPalPayment.ProductAvailabilityWS.IProductAvailabilityWS, System.ServiceModel.IClientChannel {
    }
    
    [System.Diagnostics.DebuggerStepThroughAttribute()]
    [System.CodeDom.Compiler.GeneratedCodeAttribute("System.ServiceModel", "4.0.0.0")]
    public partial class ProductAvailabilityWSClient : System.ServiceModel.ClientBase<UniSell.NET.BPEL.PayPalPayment.ProductAvailabilityWS.IProductAvailabilityWS>, UniSell.NET.BPEL.PayPalPayment.ProductAvailabilityWS.IProductAvailabilityWS {
        
        public ProductAvailabilityWSClient() {
        }
        
        public ProductAvailabilityWSClient(string endpointConfigurationName) : 
                base(endpointConfigurationName) {
        }
        
        public ProductAvailabilityWSClient(string endpointConfigurationName, string remoteAddress) : 
                base(endpointConfigurationName, remoteAddress) {
        }
        
        public ProductAvailabilityWSClient(string endpointConfigurationName, System.ServiceModel.EndpointAddress remoteAddress) : 
                base(endpointConfigurationName, remoteAddress) {
        }
        
        public ProductAvailabilityWSClient(System.ServiceModel.Channels.Binding binding, System.ServiceModel.EndpointAddress remoteAddress) : 
                base(binding, remoteAddress) {
        }
        
        [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
        UniSell.NET.BPEL.PayPalPayment.ProductAvailabilityWS.checkAvailabilityResponse UniSell.NET.BPEL.PayPalPayment.ProductAvailabilityWS.IProductAvailabilityWS.checkAvailability(UniSell.NET.BPEL.PayPalPayment.ProductAvailabilityWS.checkAvailabilityRequest request) {
            return base.Channel.checkAvailability(request);
        }
        
        public UniSell.NET.BPEL.PayPalPayment.ProductAvailabilityWS.shoppingCart checkAvailability(UniSell.NET.BPEL.PayPalPayment.ProductAvailabilityWS.shoppingCart arg0) {
            UniSell.NET.BPEL.PayPalPayment.ProductAvailabilityWS.checkAvailabilityRequest inValue = new UniSell.NET.BPEL.PayPalPayment.ProductAvailabilityWS.checkAvailabilityRequest();
            inValue.arg0 = arg0;
            UniSell.NET.BPEL.PayPalPayment.ProductAvailabilityWS.checkAvailabilityResponse retVal = ((UniSell.NET.BPEL.PayPalPayment.ProductAvailabilityWS.IProductAvailabilityWS)(this)).checkAvailability(inValue);
            return retVal.@return;
        }
        
        [System.ComponentModel.EditorBrowsableAttribute(System.ComponentModel.EditorBrowsableState.Advanced)]
        System.Threading.Tasks.Task<UniSell.NET.BPEL.PayPalPayment.ProductAvailabilityWS.checkAvailabilityResponse> UniSell.NET.BPEL.PayPalPayment.ProductAvailabilityWS.IProductAvailabilityWS.checkAvailabilityAsync(UniSell.NET.BPEL.PayPalPayment.ProductAvailabilityWS.checkAvailabilityRequest request) {
            return base.Channel.checkAvailabilityAsync(request);
        }
        
        public System.Threading.Tasks.Task<UniSell.NET.BPEL.PayPalPayment.ProductAvailabilityWS.checkAvailabilityResponse> checkAvailabilityAsync(UniSell.NET.BPEL.PayPalPayment.ProductAvailabilityWS.shoppingCart arg0) {
            UniSell.NET.BPEL.PayPalPayment.ProductAvailabilityWS.checkAvailabilityRequest inValue = new UniSell.NET.BPEL.PayPalPayment.ProductAvailabilityWS.checkAvailabilityRequest();
            inValue.arg0 = arg0;
            return ((UniSell.NET.BPEL.PayPalPayment.ProductAvailabilityWS.IProductAvailabilityWS)(this)).checkAvailabilityAsync(inValue);
        }
    }
}
