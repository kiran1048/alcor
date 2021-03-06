/*
MIT License
Copyright(c) 2020 Futurewei Cloud

    Permission is hereby granted,
    free of charge, to any person obtaining a copy of this software and associated documentation files(the "Software"), to deal in the Software without restriction,
    including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and / or sell copies of the Software, and to permit persons
    to whom the Software is furnished to do so, subject to the following conditions:

    The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
    
    THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
    FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
    WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
*/

package com.futurewei.alcor.controller.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class SubnetState extends CustomerResource {

    @JsonProperty("vpc_id")
    private String vpcId;

    @JsonProperty("cidr")
    private String cidr;

    @JsonProperty("availability_zone")
    private String availabilityZone;

    @JsonProperty("gateway_ip")
    private String gatewayIp;

    @JsonProperty("dhcp_enable")
    private Boolean dhcpEnable;

    @JsonProperty("primary_dns")
    private String primaryDns;

    @JsonProperty("secondary_dns")
    private String secondaryDns;

    @JsonProperty("dns_list")
    private List<String> dnsList;

    public SubnetState() {
    }

    public SubnetState(String projectId, String vpcId, String id, String name, String cidr) {
        this(projectId, vpcId, id, name, cidr, null, null, null, false, null, null, null);
    }

    public SubnetState(String projectId, String vpcId, String id, String name, String cidr, String gatewayIp) {
        this(projectId, vpcId, id, name, cidr, null, null, gatewayIp, false, null, null, null);
    }

    public SubnetState(SubnetState state) {
        this(state.getProjectId(), state.getVpcId(), state.getId(), state.getName(), state.getCidr(), state.getDescription(),
                state.getAvailabilityZone(), state.getGatewayIp(), state.getDhcpEnable(), state.getPrimaryDns(), state.getSecondaryDns(), state.getDnsList());
    }

    public SubnetState(String projectId, String vpcId, String id, String name, String cidr, String description, String availabilityZone,
                       String gatewayIp, Boolean dhcpEnable, String primaryDns, String secondaryDns, List<String> dnsList) {

        super(projectId, id, name, description);

        this.vpcId = vpcId;
        this.cidr = cidr;
        this.availabilityZone = availabilityZone;
        this.gatewayIp = gatewayIp;
        this.dhcpEnable = dhcpEnable;
        this.primaryDns = primaryDns;
        this.secondaryDns = secondaryDns;
        this.dnsList = (dnsList == null ? null : new ArrayList<>(dnsList));
    }

}
